package com.techboat.firstwebservice.exceptions;

import org.springframework.http.HttpStatus;

public class ElementConflict extends ApiBaseException {

    public ElementConflict(String message) {
        super(message);

    }

    @Override
    public HttpStatus getStatusCode() {

        return HttpStatus.CONFLICT;
    }

}
