package org.dalvarez.videoclub.domain.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String detail) {
        super(detail);
    }

}
