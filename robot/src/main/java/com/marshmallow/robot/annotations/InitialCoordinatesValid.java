package com.marshmallow.robot.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.marshmallow.robot.validators.InitialCoordinatesValidator;

import static com.marshmallow.robot.exception.RobotErrorConstants.INVALID_COORDINATES_MSG;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target ({ElementType.TYPE})
@Retention (RetentionPolicy.RUNTIME)
@Constraint (validatedBy = InitialCoordinatesValidator.class)
public @interface InitialCoordinatesValid {

    String message() default INVALID_COORDINATES_MSG;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
