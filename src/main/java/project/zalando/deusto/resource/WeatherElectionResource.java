package project.zalando.deusto.resource;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import project.zalando.deusto.model.WeatherElectionVO;
import project.zalando.deusto.repositories.WeatherElectionRepository;
import project.zalando.deusto.util.SpringMongoConfig;


@Path("/weather_election")
@Api(value="weatherElection")
public class WeatherElectionResource {

	private static final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	private static final WeatherElectionRepository weatherElecRepo = (WeatherElectionRepository) context.getBean("weatherElectionRepository");

	@GET
	@Path("/all")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Error when connecting to server."),
			@ApiResponse(code = 404, message = "No weather found")})
	@ApiOperation(value = "Returns all weathers.",
	response = WeatherElectionVO.class)
	public List<WeatherElectionVO> getAll() {

		System.out.println("--------------------------------------------------------");
		System.out.println(weatherElecRepo);

		return weatherElecRepo.findAll();
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	@ApiOperation(value = "Insert course in DB",
	response = Response.class)
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Could't insert data")})
	public Response insertWeather(@ApiParam(required = true) WeatherElectionVO weather) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		mongoOperation.save(weather);
		try {
			return Response.status(200).entity("OK").build();

		} catch (Exception e) {
			return Response.status(403).encoding("Bad data supplied.").build();
		}
	}

/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/byDay")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Error when connecting to server."),
			@ApiResponse(code = 404, message = "No weather found")})
	@ApiOperation(value = "Returns the weather", response = WeatherElectionVO.class)

	public WeatherElectionVO getByDay(@HeaderParam("date") String date){
		System.out.println("Searching by date...");

		return weatherElecRepo.findByDate(date);

	}*/

}


