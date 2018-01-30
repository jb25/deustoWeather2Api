package project.zalando.deusto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import project.zalando.deusto.model.WeatherElectionVO;


public interface WeatherElectionRepository extends MongoRepository<WeatherElectionVO, String>{
	public WeatherElectionVO findByDate(String date);
}
