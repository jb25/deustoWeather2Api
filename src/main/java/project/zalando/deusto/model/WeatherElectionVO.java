package project.zalando.deusto.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection="weather_election")
public class WeatherElectionVO {

	private String date;
	private String temperatureMin;
	private String temperatureMax;
	private String dayDesc;
	private String nightDesc;
	private String city;


	public WeatherElectionVO() {
		super();		
	}

	public WeatherElectionVO(String date){
		this.setDate(date);
	}

	public WeatherElectionVO(String date, String temperatureMin, String temperatureMax, String dayDesc, String nightDesc,
			String city) {
		super();
		this.date = date;
		this.temperatureMin = temperatureMin;
		this.temperatureMax = temperatureMax;
		this.dayDesc = dayDesc;
		this.nightDesc = nightDesc;
		this.city = city;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTemperatureMin() {
		return temperatureMin;
	}
	public void setTemperatureMin(String temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
	public String getTemperatureMax() {
		return temperatureMax;
	}
	public void setTemperatureMax(String temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
	public String getDayDesc() {
		return dayDesc;
	}
	public void setDayDesc(String dayDesc) {
		this.dayDesc = dayDesc;
	}
	public String getNightDesc() {
		return nightDesc;
	}
	public void setNightDesc(String nightDesc) {
		this.nightDesc = nightDesc;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "WeatherElectionVO [date=" + date + ", temperatureMin="
				+ temperatureMin + ", temperatureMax=" + temperatureMax
				+ ", dayDesc=" + dayDesc + ", nightDesc=" + nightDesc
				+ ", city=" + city + "]";
	}

}
