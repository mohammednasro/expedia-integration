package com.digisolfze.expedia.client;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.digisolfze.expedia.bean.SearchOffersResponse;
import com.digisolfze.expedia.exception.ExpediaOffersException;
import com.digisolfze.expedia.exception.enums.ExpediaOffersExceptionType;
import com.google.common.base.Strings;

import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

/**
 * A client class for interacting with the Expedia Offers API. This service
 * provides methods to fetch offers data from Expedia using different formats
 * and handles retries for requests that exceed the rate limit (HTTP 429 - Too
 * Many Requests).
 * 
 * <p>
 * The client utilizes Spring's WebClient to make reactive HTTP requests to the
 * Expedia Offers API and offers functionality to retrieve the response either
 * as an object, string, or handle errors gracefully in case of failure.
 * </p>
 * 
 * <p>
 * It supports retries with exponential backoff for specific errors, such as too
 * many requests.
 * </p>
 * 
 * @author Mohammed Nasro
 * 
 */
@Service
public class ExpediaOffersClient {

	private static final String BASE_URL = "https://offersvc.expedia.com/offers/v2/getOffers";

	@Value("${expedia.api.offers.client.id:test}")
	private String clientId;

	@Value("${expedia.api.offers.scenario:deal-finder}")
	private String scenario;

	@Value("${expedia.api.offers.product.type:Package}")
	private String productType;

	@Value("${expedia.api.offers.uid:test}")
	private String uid;

	@Value("${expedia.api.offers.page:foo}")
	private String page;

	private final WebClient webClient;

	/**
	 * Constructor that initializes the WebClient with default headers and base URL.
	 * 
	 * @param webClientBuilder The WebClient builder used to initialize the
	 *                         WebClient.
	 */
	public ExpediaOffersClient(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl(BASE_URL).defaultHeaders(headers -> {
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			headers.add("accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
			headers.add("accept-language", "en-US,en;q=0.9");
			headers.add("cache-control", "max-age=0");
			headers.add("sec-ch-ua", "\"Not A(Brand\";v=\"8\", \"Chromium\";v=\"132\", \"Google Chrome\";v=\"132\"");
			headers.add("sec-ch-ua-mobile", "?0");
			headers.add("sec-ch-ua-platform", "\"macOS\"");
			headers.add("sec-fetch-dest", "document");
			headers.add("sec-fetch-mode", "navigate");
			headers.add("sec-fetch-site", "none");
			headers.add("sec-fetch-user", "?1");
			headers.add("upgrade-insecure-requests", "1");
		}).build();
	}

	/**
	 * Fetches offers from the Expedia API as an object of
	 * {@link SearchOffersResponse}.
	 * 
	 * @param originCity      The city from where the travel originates.
	 * @param destinationCity The destination city for the travel.
	 * @return A {@link Mono} containing the response object, which represents the
	 *         offers data. Retries up to 3 times with exponential backoff for HTTP
	 *         429 responses (Too Many Requests).
	 * @throws ExpediaOffersException If the request fails after maximum retries or
	 *                                due to general errors.
	 */
	public Mono<SearchOffersResponse> fetchOffersAsObject(String originCity, String destinationCity) {

		return webClient.get().uri(uriBuilder -> {
			uriBuilder.queryParam("scenario", scenario).queryParam("page", page).queryParam("uid", uid)
					.queryParam("productType", productType).queryParam("clientId", clientId);

			if (!Strings.isNullOrEmpty(originCity)) {
				uriBuilder.queryParam("originCity", originCity);
			}
			if (!Strings.isNullOrEmpty(destinationCity)) {
				uriBuilder.queryParam("destinationCity", destinationCity);
			}

			return uriBuilder.build();
		}).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(SearchOffersResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(2))
						.filter(throwable -> throwable instanceof WebClientResponseException.TooManyRequests)
						.onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> new ExpediaOffersException(
								ExpediaOffersExceptionType.TOO_MANY_REQUESTS,
								"Failed after max retries due to 429 Too Many Requests")))
				.doOnError(error -> new ExpediaOffersException(ExpediaOffersExceptionType.GENERAL_ERROR,
						"Error fetching offers: " + error.getMessage()));
	}

	/**
	 * Fetches offers from the Expedia API as an object, blocking the response for
	 * immediate processing.
	 * 
	 * @param originCity      The city from where the travel originates.
	 * @param destinationCity The destination city for the travel.
	 * @return A {@link SearchOffersResponse} representing the offers data. If there
	 *         is an error or the request fails, it throws an exception.
	 * @throws ExpediaOffersException If the request fails.
	 */
	public SearchOffersResponse fetchOffers(String originCity, String destinationCity) {

		return fetchOffersAsObject(originCity, destinationCity).block();

	}

	/**
	 * Fetches offers from the Expedia API as a raw JSON string.
	 * 
	 * @param originCity      The city from where the travel originates.
	 * @param destinationCity The destination city for the travel.
	 * @return A {@link Mono} containing the response as a JSON string. Retries up
	 *         to 3 times with exponential backoff for HTTP 429 responses (Too Many
	 *         Requests).
	 * @throws ExpediaOffersException If the request fails after maximum retries or
	 *                                due to general errors.
	 */
	public Mono<String> fetchOffersAsString(String originCity, String destinationCity) {
		return webClient.get().uri(uriBuilder -> {
			uriBuilder.queryParam("scenario", scenario).queryParam("page", page).queryParam("uid", uid)
					.queryParam("productType", productType).queryParam("clientId", clientId);

			if (!Strings.isNullOrEmpty(originCity)) {
				uriBuilder.queryParam("originCity", originCity);
			}
			if (!Strings.isNullOrEmpty(destinationCity)) {
				uriBuilder.queryParam("destinationCity", destinationCity);
			}

			return uriBuilder.build();
		}).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(2))
						.filter(throwable -> throwable instanceof WebClientResponseException.TooManyRequests)
						.onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> new ExpediaOffersException(
								ExpediaOffersExceptionType.TOO_MANY_REQUESTS,
								"Failed after max retries due to 429 Too Many Requests")))
				.doOnError(error -> new ExpediaOffersException(ExpediaOffersExceptionType.GENERAL_ERROR,
						"Error fetching offers: " + error.getMessage()));
	}
}
