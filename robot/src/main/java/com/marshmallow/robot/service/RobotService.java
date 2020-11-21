package com.marshmallow.robot.service;

import java.util.Optional;

import com.marshmallow.robot.model.RobotRequest;
import com.marshmallow.robot.model.RobotResponse;

public interface RobotService {

	public Optional<RobotResponse> clean(RobotRequest request);
}
