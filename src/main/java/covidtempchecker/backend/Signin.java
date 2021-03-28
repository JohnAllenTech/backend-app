package covidtempchecker.backend;

import java.util.Date;

public class Signin {
	long key;
	User user;
	double temperature;
	Date currentDate;
	
	public Signin() {
	}
	
	public Signin(int key,User user, double temperature, Date currentDate) {
		this.key = key;
		this.user = user;
		this.temperature = temperature;
		this.currentDate = currentDate;
	}

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	@Override
	public String toString() {
		return "Signin{" +
				"key=" + key +
				", user=" + user +
				", temperature=" + temperature +
				", currentDate=" + currentDate +
				'}';
	}
}
