package project.zalando.deusto.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import project.zalando.deusto.model.WeatherElectionVO;
import project.zalando.deusto.repositories.WeatherElectionRepository;

public class Test {
	public void testUsingRepositories() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		WeatherElectionRepository repository = (WeatherElectionRepository) context.getBean("weatherElectionRepository");
		repository.deleteAll();

		WeatherElectionVO w1 = new WeatherElectionVO("2018-01-12T07:00:00+01:00", "46", "56", "Intermittent clouds", "Mostly cloudy w/ showers", "bilbao");
		WeatherElectionVO w2 = new WeatherElectionVO("2018-01-12T07:00:00+04:00", "43", "54", "clouds", "Mostly rainny w/ showers", "vitoria");


		repository.save(w1);
		repository.save(w2);

	
		System.out.println("\nWeather found with findAll():");
		System.out.println("-------------------------------");
		for (WeatherElectionVO weather : repository.findAll()) {
			System.out.println(weather);
		}
		
/*
		System.out.println("\nWeather found with findByDate(''):");
		System.out.println("--------------------------------");
		for (WeatherElectionVO weather : repository.findByDate("2018-01-12T07:00:00+01:00")) {
			System.out.println(weather);
		}*/

	}

	public void printWeatherDetails(WeatherElectionVO w) {
		System.out.println(w);
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.testUsingRepositories();
	}
}
