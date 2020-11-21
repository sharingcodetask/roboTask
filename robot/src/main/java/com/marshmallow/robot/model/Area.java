package com.marshmallow.robot.model;

import lombok.Value;
import com.marshmallow.robot.exception.RobotInvalidOilPatchArea;

import java.util.List;

import static com.marshmallow.robot.model.Grid.CLEAN;
import static com.marshmallow.robot.model.Grid.OIL_PATCH;

/**
 * Represents the Area of our Robot Cleaner.
 *
 */
@Value
public class Area {

    private Grid[][] grids;
    private AreaSize areaSize;

    public Area(AreaSize areaSize) {
        this.areaSize = areaSize;
        Integer x = areaSize.getX();
        Integer y = areaSize.getY();
        grids = new Grid[x][y];

        // Set up a grid
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grids[i][j] = CLEAN;
            }
        }
    }

    /**
     * Adds the oil patch to a certain grid
     *
     * @param  coordinates       Coordinates of the oil patch as a List
     * @param  oilPatchIndex  The index or the number of the oil patch
     * @throws RobotInvalidOilPatchArea
     */
    public void applyOilPatch(List<Integer> coordinates, int oilPatchIndex) {
        applyOilPatch(coordinates.get(0), coordinates.get(1), oilPatchIndex);
    }

    /**
     * Adds the oil patch to a certain coordinates
     *
     * @param x  The x coordinate
     * @param y  The y coordinate
     */
    public void applyOilPatch(int x, int y, int oilPatchIndex) {
        if (x >= areaSize.getX() ||
            y >= areaSize.getY()) {
            throw new RobotInvalidOilPatchArea(oilPatchIndex);
        }
        grids[x][y] = OIL_PATCH;
    }

    /**
     * Checks if a certain grid has oil patch
     *
     * @param  position  Position to check
     * @return boolean   true if it has, false otherwise
     */
    public boolean hasOilPatch(Position position) {
        return grids[position.getX()][position.getY()] == OIL_PATCH;
    }

    /**
     * Removes the oil patch from a certain grid
     *
     * @param  position  Position to remove oil patch from
     */
    public void removeOilPatch(Position position) {
        grids[position.getX()][position.getY()] = CLEAN;
    }
}
