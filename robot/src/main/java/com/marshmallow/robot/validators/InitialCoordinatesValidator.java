package com.marshmallow.robot.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.marshmallow.robot.annotations.InitialCoordinatesValid;
import com.marshmallow.robot.model.RobotRequest;

/** Checks validity of areaSize and startingPosition
 * @author sunil
 *
 */
public class InitialCoordinatesValidator implements ConstraintValidator<InitialCoordinatesValid, Object> {
    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext constraintValidatorContext) {
        // Non-null + Pair + Positive Values
    	final RobotRequest request = (RobotRequest) obj;
        return (request.getStartingPosition() != null) && (request.getStartingPosition().size() == 2) &&
        	   (request.getAreaSize() != null) && (request.getAreaSize().size() == 2) && 
        	   (request.getStartingPosition().get(0) < request.getAreaSize().get(0)) && 
        	   (request.getStartingPosition().get(1) < request.getAreaSize().get(1));
    }
}
