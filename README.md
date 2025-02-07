# Expedia Integration

## Overview
Expedia Integration is a Spring Boot-based API designed to interact with the Expedia API and search for package offers. The project is structured to be lightweight, efficient, and easily extensible.

## Features
- RESTful API for searching Expedia packages.
- Built using Spring Boot (version 3.4.2).
- Uses WebFlux for reactive programming.
- Integrated with OpenAPI (Swagger UI) for API documentation.
- Actuator support for application monitoring.
- Default port: **8080**.
- Includes an HTML UI page to display offers: [http://localhost:8080/index.html](http://localhost:8080/index.html).

## Technologies Used
- **Java 17**
- **Spring Boot 3.4.2**
- **Spring WebFlux**
- **MapStruct for object mapping**
- **Lombok for reducing boilerplate code**
- **SpringDoc OpenAPI for API documentation**
- **SLF4J for logging**
- **Apache Commons Lang3**

## Prerequisites
Ensure you have the following installed:
- **Java 17**
- **Maven**

## Installation & Running
1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd expedia-integration
   ```
2. Build the project:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## Building JAR File
To package the application into a JAR file, run:
```sh
mvn clean package
```
The JAR file will be available in the `target/` directory.

To run the JAR file:
```sh
java -jar target/expedia-integration-0.0.1-SNAPSHOT.jar
```

## API Endpoints
### 1. **Search Offers**
- **Endpoint:** `GET /api/offers`
- **Description:** Retrieves a list of available Expedia package offers.
- **Query Parameters:**
  - `originCity` (String) - The city from which the package will depart.
  - `destinationCity` (String) - The city where the package will arrive.

- **Example Request:**
  ```sh
  curl -X GET "http://localhost:8080/v1/expedia/offers?originCity=Amman&destinationCity=New%20York"
  ```

### 3. **Health Check**
- **Endpoint:** `GET /actuator/health`
- **Description:** Checks if the service is running.

## Configuration Properties
The application supports the following properties 
```properties

server.port=8080
expedia.api.offers.client.id=test
expedia.api.offers.scenario=deal-finder
expedia.api.offers.product.type=Package
expedia.api.offers.uid=test
expedia.api.offers.page=foo
```
- `server.port`: The port on which the application runs (default **8080**).
- `expedia.api.offers.client.id`: Client ID for Expedia API Offers.
- `expedia.api.offers.scenario`: Scenario type for the Expedia Offers API request.
- `expedia.api.offers.product.type`: Product type to be used in Expedia Offers API (e.g., Package).
- `expedia.api.offers.uid`: Unique Identifier (UID) for the Expedia Offers API request.
- `expedia.api.offers.page`: Page value to be used in the request to Expedia Offers API

## API Documentation
Once the application is running, you can access the API documentation via Swagger UI:
```
http://localhost:8080/swagger-ui.html
```

## UI Page
- The project includes an **HTML UI page** for viewing Expedia offers.
- Access it via: [http://localhost:8080/index.html](http://localhost:8080/index.html).

## Deployment
For production deployment, consider:
- Configuring a proper logging mechanism.
- Setting up environment-specific properties.

## Contributing
Feel free to submit issues or pull requests for enhancements.

