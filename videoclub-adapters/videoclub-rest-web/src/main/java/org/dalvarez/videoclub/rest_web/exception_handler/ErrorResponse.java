package org.dalvarez.videoclub.rest_web.exception_handler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private int httpStatus;

    private String type, message, clazz, method;

    private int line;

}
