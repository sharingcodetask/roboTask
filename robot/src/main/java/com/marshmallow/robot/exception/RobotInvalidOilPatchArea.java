package com.marshmallow.robot.exception;

import static com.marshmallow.robot.exception.RobotErrorConstants.INVALID_OILPATCHES_AREA_MSG;
public class RobotInvalidOilPatchArea extends GenericException {

	public RobotInvalidOilPatchArea(int oilPatchIndex) {
		super(INVALID_OILPATCHES_AREA_MSG, oilPatchIndex);
	}

}
