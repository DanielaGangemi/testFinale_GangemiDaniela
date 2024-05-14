package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dto.CityShowDto;
import it.corso.service.CityService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/city")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GET
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCourses() {

		try {

			List<CityShowDto> cityList = cityService.findAll();
			return Response.status(Response.Status.OK).entity(cityList).build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
