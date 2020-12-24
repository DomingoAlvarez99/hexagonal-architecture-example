package org.dalvarez.videoclub.domain.models.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotated element must not be empty. Accepts any type.
 */

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ListNotEmptyValidator.class)
public @interface ListNotEmpty {

    String message() default "Expected not empty and not null";

    Class< ? >[] groups() default {};

    Class< ? extends Payload>[] payload() default {};

}
