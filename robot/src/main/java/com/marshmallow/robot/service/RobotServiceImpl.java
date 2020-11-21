package com.marshmallow.robot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.marshmallow.robot.model.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
@Slf4j
public class RobotServiceImpl implements RobotService {

	public Optional<RobotResponse> clean(RobotRequest request) {

		AreaSize areaSize = new AreaSize(request.getAreaSize());
		Area area = new Area(areaSize);

		// Apply oil patch
		List<List<Integer>> oilPatches = request.getOilPatches();
		IntStream.range(0, oilPatches.size()).forEach(index -> area.applyOilPatch(oilPatches.get(index), index));

		// Now start the cleaner
		Position startingPosition = new Position(request.getStartingPosition(), areaSize);
		RobotCleaner robot = new RobotCleaner(area, startingPosition);
		RobotResponse response = robot.clean(request.getNavigationInstructions());

		if (response == null) {
			log.error("Error encountered during the cleaning. No solution found.");
			return Optional.empty();
		}

		log.info("Robot Cleaner finished cleaning ...");
		return Optional.of(response);
	}
}
