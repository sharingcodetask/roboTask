package com.marshmallow.robot.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.marshmallow.robot.annotations.NavigationInstructions;

public class NavigationInstructionsValidator implements ConstraintValidator<NavigationInstructions, String> {
	@Override
	public boolean isValid(String navigationInstructions, ConstraintValidatorContext constraintValidatorContext) {
		if (navigationInstructions.isEmpty()) {
			return false;
		}

		return !(navigationInstructions.chars().mapToObj(c -> (char) c).anyMatch(
				i -> (i.charValue() != 'N' && i.charValue() != 'S' && i.charValue() != 'W' && i.charValue() != 'E')));

	}
}
