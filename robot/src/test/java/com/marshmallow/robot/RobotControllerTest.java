package com.marshmallow.robot;


import static com.marshmallow.robot.exception.RobotErrorConstants.INVALID_COORDINATES_MSG;
import static com.marshmallow.robot.exception.RobotErrorConstants.INVALID_DIRECTION_MSG;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marshmallow.robot.controller.RobotController;
import com.marshmallow.robot.model.Position;
import com.marshmallow.robot.model.RobotRequest;
import com.marshmallow.robot.model.RobotResponse;
import com.marshmallow.robot.service.RobotService;;


@WebMvcTest(RobotController.class)
public class RobotControllerTest {



	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RobotService service;

    @Test
    public void testSampleData() throws JsonProcessingException, Exception {
  	    
    	RobotRequest request = new RobotRequest(List.of(5,5), List.of(1,3),List.of(List.of(1,0),List.of(2,2),List.of(2,3)), "NNESEESWNWW");
    	
    	Optional<RobotResponse> response = Optional.of(new RobotResponse(new Position(List.of(1,3), null), 1));
    	when(service.clean(request)).thenReturn(response);


		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/robots/clean")
				.content(new ObjectMapper().writeValueAsString(request)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.oilPatchesCleaned").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.finalPosition[0]").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.finalPosition[1]").value(3));
	
    }
    
    @Test
    public void testInvalidDirection() throws JsonProcessingException, Exception {
  	    
    	RobotRequest request = new RobotRequest(List.of(5,5), List.of(1,3),List.of(List.of(1,0),List.of(2,2),List.of(2,3)), "NNESEESWNWWP");
    	
    	Optional<RobotResponse> response = Optional.of(new RobotResponse(new Position(List.of(1,3), null), 1));
    	when(service.clean(request)).thenReturn(response);


		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/robots/clean")
				.content(new ObjectMapper().writeValueAsString(request)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(result -> result.getResolvedException().getMessage().contains(INVALID_DIRECTION_MSG));

	
    }
    
    @Test
    public void testInvalidCoordidates() throws JsonProcessingException, Exception {
  	    
    	RobotRequest request = new RobotRequest(List.of(5), List.of(1,3),List.of(List.of(1,0),List.of(2,2),List.of(2,3)), "NNESEESWNWW");
    	
    	Optional<RobotResponse> response = Optional.of(new RobotResponse(new Position(List.of(1,3), null), 1));
    	when(service.clean(request)).thenReturn(response);


		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/robots/clean")
				.content(new ObjectMapper().writeValueAsString(request)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(result -> result.getResolvedException().getMessage().contains(INVALID_COORDINATES_MSG));

	
    }
  


}
