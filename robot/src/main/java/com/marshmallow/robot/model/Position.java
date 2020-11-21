package com.marshmallow.robot.model;

import lombok.Data;

import java.util.List;

import com.marshmallow.robot.validators.CurrentPositionValidator;

/**
 * Class that represent area to be cleaned initially and then cleaned up.
 */
@Data
public class Position implements CurrentPositionValidator {

    private AreaSize areaSize;
    private Integer x;
    private Integer y;

    public Position(List<Integer> coordinates, AreaSize areaSize) {
        x = coordinates.get(0);
        y = coordinates.get(1);
        this.areaSize = areaSize;
    }

    public void setLocation(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    public void incrementX() {
        x++;
    }

    public void decrementX() {
        x--;
    }

    public void incrementY() {
        y++;
    }

    public void decrementY() {
        y--;
    }

    /**
     * Checks if a position is inside the area.
     */
    @Override
    public boolean isValid() {
        return (areaSize != null) && (x >= 0) && (x < areaSize.getX()) && (y >= 0) && (y < areaSize.getY());
    }
}
