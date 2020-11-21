package com.marshmallow.robot.controller;

import static com.marshmallow.robot.exception.RobotErrorConstants.GENERIC_ERROR_MSG;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marshmallow.robot.exception.GenericException;
import com.marshmallow.robot.model.RobotRequest;
import com.marshmallow.robot.model.RobotResponse;
import com.marshmallow.robot.service.RobotService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/robots")
@ApiOperation(value = "Available operations for Robo Cleaner")
@RequiredArgsConstructor
public class RobotController {

	@Autowired
	private RobotService robotService;

	@PostMapping(path = "/clean", produces = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<RobotResponse> clean(@RequestBody @Valid RobotRequest request) {

		Optional<RobotResponse> response = robotService.clean(request);
		if (response.isPresent())
			return new ResponseEntity<>(response.get(), HttpStatus.OK);

		throw new GenericException(GENERIC_ERROR_MSG);
	}
}
