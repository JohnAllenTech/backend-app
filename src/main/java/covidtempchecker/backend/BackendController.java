package covidtempchecker.backend;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*") // Used to ensure that frontend can perform REST Calls from port 4200
public class BackendController{
	
	@Autowired
	private hardCodedService temperatureService;
	
	@GetMapping(path= "/signins")
	public List<Signin> getAllSignins(){
		return temperatureService.getAll();
	}
	
	@GetMapping(path= "/signins/{key}")
	public Signin getAllSignins(@PathVariable int key){
		return temperatureService.getBykey(key);
	}
	
	@DeleteMapping(path= "/signins/{key}")
	public ResponseEntity<Void> deteleSignin(@PathVariable int key){
		 Signin signin = temperatureService.deleteByKey(key);
		 
		 if(signin!=null) {
			 return ResponseEntity.noContent().build();
		 }
		 return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/signins/-1")
	public ResponseEntity<Void> createSignin(@RequestBody Signin signin){
		Signin createdSignin = temperatureService.save(signin,-1);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{key}").buildAndExpand(createdSignin.getKey()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/signins/{key}")
	public ResponseEntity<Void> updateSignin(@PathVariable int key,@RequestBody Signin signin){
		Signin createdSignin = temperatureService.save(signin,key);

		return new ResponseEntity(createdSignin,HttpStatus.OK);
	}
	
	
}
