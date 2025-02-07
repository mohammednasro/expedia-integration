package com.digisolfze.expedia.exception;

import com.digisolfze.expedia.exception.enums.ExpediaOffersExceptionType;

/**
 * Custom exception class to handle specific errors related to Expedia offers processing.
 * This exception extends {@link RuntimeException} and provides an additional {@link ExpediaOffersExceptionType}
 * to categorize different types of errors that can occur during the execution of Expedia offers operations.
 * 
 * <p>It is designed to be thrown in scenarios where specific error conditions are encountered, such as issues
 * with external API calls, invalid data, or business logic errors.</p>
 * 
 * <p>The exception type provides a structured way to classify the exception, enabling better handling
 * and categorization of errors in the system.</p>
 * 
 * @author Mohammed Nasro
 */
public class ExpediaOffersException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * The type of the exception, which helps categorize the error.
     */
    private final ExpediaOffersExceptionType type;

    /**
     * Retrieves the exception type.
     * 
     * @return the {@link ExpediaOffersExceptionType} representing the specific error type.
     */
    public ExpediaOffersExceptionType getType() {
        return type;
    }

    /**
     * Constructs a new {@code ExpediaOffersException} with the specified exception type and message.
     * 
     * @param type the type of exception, which provides the error category.
     * @param message the detailed message explaining the cause of the exception.
     */
    public ExpediaOffersException(ExpediaOffersExceptionType type, final String message) {
        super(message);
        this.type = type;
    }
}
