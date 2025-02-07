package com.digisolfze.expedia.exception.enums;

/**
 * Enum that defines the various types of exceptions that can occur within the context of Expedia offers.
 * This enum is used to categorize different error conditions, providing a structured way to identify and handle errors
 * in the application related to Expedia offers processing.
 * 
 * <p>Each enum value corresponds to a specific type of error, which can be associated with exceptions thrown
 * during the execution of operations such as API calls or business logic processing.</p>
 *
 * @author Mohammed Nasro
 * 
 */
public enum ExpediaOffersExceptionType {
    
    /**
     * Represents a general error that does not fall into a specific category.
     * This can be used for unforeseen issues or unspecified errors.
     */
    GENERAL_ERROR,

    /**
     * Represents an error caused by exceeding the rate limit for requests to the Expedia offers service.
     * Typically triggered by HTTP 429 - Too Many Requests.
     */
    TOO_MANY_REQUESTS;
}
