package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@SpringBootApplication
@RestController
public class Application {

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	public static final String MESSAGE_KEY = "message:";
 

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, String> helloWorld() throws UnknownHostException {
        return getResponse();
    }
    
    @GetMapping(path = "/{cualquier}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, String> helloWorld2(@PathVariable(value = "cualquier") String cualquier) throws UnknownHostException {
        return getResponse2();
    }

    private Map<String, String> getResponse() throws UnknownHostException {

		Map<String, String> response = new HashMap<>();
		response.put("date:" ,java.time.LocalDateTime.now().toString());
        response.put(MESSAGE_KEY, "Hello World!");
        
        
        return response;
    }
    
   
    private Map<String, String> getResponse2() throws UnknownHostException {
        Map<String, String> response = new HashMap<>();
        response.put(MESSAGE_KEY,"You are not authorized to access this page");
        
       
        return response;
    }
    public String getCurrentTimeUsingDate() {
	    Date date = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(date);
	    return "Current time of the day using Date - 12 hour format: " + formattedDate;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
