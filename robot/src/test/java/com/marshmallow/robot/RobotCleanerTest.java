package com.marshmallow.robot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.marshmallow.robot.model.Area;
import com.marshmallow.robot.model.AreaSize;
import com.marshmallow.robot.model.Position;
import com.marshmallow.robot.model.RobotResponse;
import com.marshmallow.robot.service.RobotCleaner;

public class RobotCleanerTest {


    @Test
    public void testSampleData() {

    	AreaSize areaSize = new AreaSize(Arrays.asList(5, 5));
        Area area = new Area(areaSize);

        Position position = new Position(Arrays.asList(1, 2), areaSize);
        area.applyOilPatch(1, 0, 0);
        area.applyOilPatch(2, 2, 1);
        area.applyOilPatch(2, 3, 2);
        String navigationInstructions = "NNESEESWNWW";	
        RobotCleaner roboCleaner = new RobotCleaner(area, position);

        RobotResponse response = roboCleaner.clean(navigationInstructions);

        assertNotNull(response);
        assertEquals(1, response.getOilPatchesCleaned());
        assertEquals(Arrays.asList(1, 3), response.getFinalPosition());
    }



}
