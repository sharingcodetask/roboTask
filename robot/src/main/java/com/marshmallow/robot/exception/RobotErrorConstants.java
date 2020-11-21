package com.marshmallow.robot.exception;

public final class RobotErrorConstants {

    private RobotErrorConstants() {
            // restrict instantiation
    }

    public static final String INVALID_DIRECTION_MSG = "The accepted sequence of characters for navigationInstructions are N, S, E and W (indicative of directions)";
    public static final String INVALID_COORDINATES_MSG = "Please check format of startinPosition/areaSize (x,y) and boundaries range";
    public static final String INVALID_OILPATCHES_MSG = "OilPatches must be valid coordinates(x,y)";
    public static final String GENERIC_ERROR_MSG = "Error encountered during the Robo Cleaner navigation";
    public static final String INVALID_OILPATCHES_AREA_MSG = "Oil patch coordinates are outside of the areaSize: ";
}