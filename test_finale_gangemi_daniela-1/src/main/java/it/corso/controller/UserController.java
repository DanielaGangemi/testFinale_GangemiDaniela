package it.corso.controller;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.corso.dto.UserLoginRequestDto;
import it.corso.dto.UserLoginResponseDto;
import it.corso.dto.UserRegistrationDto;
import it.corso.dto.UserShowDto;
import it.corso.model.User;
import it.corso.service.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 1. USER REGISTRATION
	@POST
	@Path("/registration")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registration(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {

		try {

			if (!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}",
					userRegistrationDto.getPassword())) {

				return Response.status(Response.Status.BAD_REQUEST).build();

			}

			if (userService.existsByEmail(userRegistrationDto.getEmail())) {

				return Response.status(Response.Status.BAD_REQUEST).build();
			}

			userService.userRegistration(userRegistrationDto);

			return Response.status(Response.Status.OK).build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}

	// 2. LOGIN
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response userLogin(@RequestBody UserLoginRequestDto userLoginRequestDto) {

		try {

			if (userService.userLogin(userLoginRequestDto)) {

				return Response.status(Response.Status.OK).entity(issueToken(userLoginRequestDto.getEmail())).build();

			}

			return Response.status(Response.Status.BAD_REQUEST).build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).build();

		}

	}

	// 2.1 TOKEN GENERATION
	private UserLoginResponseDto issueToken(String email) {

		// eseguiamo una cifratura attraverso l'algoritmo di crittografia HMAC
		byte[] secretKey = "!!!!aaaaabbbbbbb@@@@@ccccccccccc1$$$$$dddddddddd11111122222222222233333333333".getBytes();

		// crittografia
		Key key = Keys.hmacShaKeyFor(secretKey);

		User user = userService.findByEmail(email);

		Map<String, Object> map = new HashMap<>();

		map.put("first_name", user.getFirstName());
		map.put("last_name", user.getLastName());
		map.put("email", user.getEmail());

		Date creation = new Date();
		Date end = java.sql.Timestamp.valueOf(LocalDateTime.now().plusMinutes(15L));

		String jwtToken = Jwts.builder().setClaims(map).setIssuer("http://localhost:8080").setIssuedAt(creation)
				.setExpiration(end).signWith(key).compact();

		UserLoginResponseDto token = new UserLoginResponseDto();

		token.setToken(jwtToken);
		token.setTtl(end);
		token.setTokenCreationTime(creation);

		return token;

	}

	// 3. FIND BY EMAIL
	@GET
	@Path("/show")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByEmail(@QueryParam("email") String email) {

		try {

			if (email != null && !email.isEmpty()) {

				UserShowDto utenteShowDto = userService.findUserByEmail(email);

				return Response.status(Response.Status.OK).entity(utenteShowDto).build();

			}

			return Response.status(Response.Status.BAD_REQUEST).build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).build();

		}

	}
}
