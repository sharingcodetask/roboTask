package com.marshmallow.robot.model;

import lombok.Value;

import java.util.List;

/**
 * Holds the dimensions of the Area.
 *
 */
@Value
public class AreaSize {

    private Integer x;
    private Integer y;

    public AreaSize(List<Integer> values) {
        x = values.get(0);
        y = values.get(1);
    }
}
