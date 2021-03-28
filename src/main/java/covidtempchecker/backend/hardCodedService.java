package covidtempchecker.backend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class hardCodedService {
	private static List<Signin> temperatures = new ArrayList<>();
	
	private static int keyCounter=1;
	
	static {
		temperatures.add(new Signin(keyCounter++,new User("John Allen",1234567,"Engineering"),69.0,new Date()));
		temperatures.add(new Signin(keyCounter++,new User("Jade Allen",987654,"HR"),100.0,new Date()));
		temperatures.add(new Signin(keyCounter++,new User("Daithi Dunne",144231,"Mechanical Department"),43.0,new Date()));
		temperatures.add(new Signin(keyCounter++,new User("Lizzie Dunne",123412,"Education"),23.0,new Date()));
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

//		for (Signin s: temperatures) {
//			System.out.println(s.toString());
//		}
//		System.out.println();
		
		return signin;
	}
	
	public List<Signin> getAll(){
		return temperatures;
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
