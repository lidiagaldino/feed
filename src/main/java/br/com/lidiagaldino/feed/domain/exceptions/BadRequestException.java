package br.com.lidiagaldino.feed.domain.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
