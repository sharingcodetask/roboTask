package com.marshmallow.robot.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.marshmallow.robot.validators.OilPatchesValidator;

import static com.marshmallow.robot.exception.RobotErrorConstants.INVALID_OILPATCHES_MSG;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target ({ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)
@Constraint (validatedBy = OilPatchesValidator.class)
public @interface OilPatches {

    String message() default INVALID_OILPATCHES_MSG;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
