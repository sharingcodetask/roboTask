package com.marshmallow.robot.service;

import com.marshmallow.robot.model.Area;
import com.marshmallow.robot.model.Position;
import com.marshmallow.robot.model.RobotResponse;

public class RobotCleaner {

    private Position previousPosition;
    private Area area;
    private Position position;
    private int oilPatchesCleaned;

    /**
     * @param area       			Playground area for Robot to clean.
     * @param startingPosition  	Initial Position of the Robot Cleaner
     */
    public RobotCleaner(Area area, Position startingPosition) {
        this.area = area;
        this.position = startingPosition;
        previousPosition = startingPosition;
        oilPatchesCleaned = 0;
    }

    /**
     * Makes the Robo Cleaner to move to a direction
     *
     * @param direction  Direction to move
     */
    private void move(char direction) {
        previousPosition.setLocation(position);

        switch (direction) {
            case 'N':
                position.incrementY();
                break;
            case 'S':
                position.decrementY();
                break;
            case 'E':
                position.incrementX();
                break;
            case 'W':
                position.decrementX();
                break;
            default:
                break;
        }

        // If a position is not in the area, the robot stays in the same place
        if (position.isValid()) {
            doClean(position);
        } else {
            position.setLocation(previousPosition);
        }
    }

    /**
     * @param  navigationInstructions  	Directions to move
     * @return Response             	The final state
     */
    public RobotResponse clean(String navigationInstructions) {

        for (int i = 0; i < navigationInstructions.length(); i++) {
            move(navigationInstructions.charAt(i));
        }

        return new RobotResponse(position, oilPatchesCleaned);
    }

    /**
     * @param position  Coordinates with potential oil patch to be cleaned
     */
    private void doClean(Position position) {
        if (area.hasOilPatch(position)) {
            area.removeOilPatch(position);
            oilPatchesCleaned++;
        }
    }
}
