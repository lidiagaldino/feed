package br.com.lidiagaldino.feed.domain.exceptions;

public class ExceptionResponse {
    public String message;
    public int code;

    public ExceptionResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
