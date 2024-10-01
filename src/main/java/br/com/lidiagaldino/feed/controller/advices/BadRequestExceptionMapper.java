package br.com.lidiagaldino.feed.controller.advices;

import br.com.lidiagaldino.feed.domain.exceptions.BadRequestException;
import br.com.lidiagaldino.feed.domain.exceptions.ExceptionResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ExceptionResponse(e.getMessage(), 400))
                .build();
    }
}
