package com.marshmallow.robot.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.marshmallow.robot.validators.NavigationInstructionsValidator;

import static com.marshmallow.robot.exception.RobotErrorConstants.INVALID_DIRECTION_MSG;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target ({ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)
@Constraint (validatedBy = NavigationInstructionsValidator.class)
public @interface NavigationInstructions {

    String message() default INVALID_DIRECTION_MSG;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
