package com.marshmallow.robot.model;

import lombok.Value;

import java.util.Arrays;
import java.util.List;

/**
 * Class that represent the final state of area
 */
@Value
public class RobotResponse {

    private List<Integer> finalPosition;
    private int oilPatchesCleaned;


    public RobotResponse(Position position, int oilPatchesCleaned) {
        this.finalPosition = Arrays.asList(position.getX(), position.getY());
        this.oilPatchesCleaned = oilPatchesCleaned;
    }
}
