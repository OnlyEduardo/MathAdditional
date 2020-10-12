package com.mathAdditional.Exceptions;

/**
 * The class {@code CannotUseMatrixException} and its subclasses are a form of
 * {@code MAExceptions} that indicates conditions that a reasonable
 * application might want to catch.
 *
 * @author Eduardo Ribeiro Leal
 * @version 1.0.0
 * @see com.mathAdditional.Exceptions
 */
public class CannotUseMatrixException extends  MAExceptions {

    /**
     * Docs are the same as {@link #Exception} class.
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public CannotUseMatrixException(){
        super("matrix cannot be used for this function");
    }
}
