package com.marshmallow.robot.model;

import java.util.List;

import com.marshmallow.robot.annotations.NavigationInstructions;
import com.marshmallow.robot.annotations.OilPatches;
import com.marshmallow.robot.annotations.InitialCoordinatesValid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
@Data
@InitialCoordinatesValid
@AllArgsConstructor
public class RobotRequest {


    private List<Integer> areaSize;

 
    private List<Integer> startingPosition;

    @OilPatches
    private List<List<Integer>> oilPatches;

    @NavigationInstructions
    private String navigationInstructions;
}
