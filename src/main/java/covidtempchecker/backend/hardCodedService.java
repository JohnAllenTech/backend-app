package covidtempchecker.backend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class hardCodedService {
	private static List<Signin> temperatures = new ArrayList<>();
	
	private static int keyCounter=1;
	
	static {
		temperatures.add(new Signin(keyCounter++,new User("John Allen",1234567,"Engineering"),13.0));
		temperatures.add(new Signin(keyCounter++,new User("Jade Allen",987654,"HR"),20.0));
		temperatures.add(new Signin(keyCounter++,new User("Daithi Dunne",144231,"Mechanical Department"),43.0));
		temperatures.add(new Signin(keyCounter++,new User("Lizzie Dunne",123412,"Education"),18.0));
	}
	
	public  Signin save(Signin signin, int key){
		if(key==-1 || key==0 ){
			signin.setKey(keyCounter++); // found you little bug
			temperatures.add(signin);
		}
		else {
			temperatures.remove(key-1);
			signin.setKey(key); // found you little bug
			temperatures.add(signin);
		}
		return signin;
	}
	
	public List<Signin> getAll(){
		return temperatures;
	}

	public JSONArray getAllForGraph(){
		JSONArray temperatureArray = new JSONArray();

		for (Signin elem: temperatures) {
			temperatureArray.put(new JSONObject().put("x",elem.key).put("y",elem.temperature));
		}
		System.out.println(temperatureArray.toString());


		return temperatureArray;
	}

	public Signin getBykey(int key) {
		for(Signin signin : temperatures) {
			if(signin.getKey()== key) {
				return signin;
			}
		}
		return null;
			
	}

	public Signin deleteByKey(int key) {
		Signin signin = getBykey(key);
		if(temperatures.remove(signin)) {
			return signin;
		}
		else {
			return null;
		}
	}

}
