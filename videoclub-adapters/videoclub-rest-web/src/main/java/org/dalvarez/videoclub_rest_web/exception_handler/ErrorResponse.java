package org.dalvarez.videoclub_rest_web.exception_handler;

import com.dalvarez.videoclub.domain.exceptions.NotFoundException;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
@Builder
public class ErrorResponse {

    private int httpStatus;

    private String type, message, clazz, method;

    private int line;

}
