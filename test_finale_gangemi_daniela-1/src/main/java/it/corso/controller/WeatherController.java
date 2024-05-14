package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import it.corso.dto.WeatherInsertDto;
import it.corso.service.WeatherService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCourses(@RequestBody WeatherInsertDto weatherInsertDto) {

		try {

			weatherService.insert(weatherInsertDto);

			return Response.status(Response.Status.OK).build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
