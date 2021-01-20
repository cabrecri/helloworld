package com.testing;

import static org.slf4j.LoggerFactory.getLogger;


import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A very basic Hello World controller which returns the hostname.
 *
 * @author Cristian cabrera cabrecri@gmail.com
 *
 */
@RestController
public class HelloWorldController {

    private static final Logger LOG = getLogger(HelloWorldController.class.getName());

    public static final String MESSAGE_KEY = "message:";
 

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, String> helloWorld() throws UnknownHostException {
        return getResponse();
    }
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, String> wellcome() throws UnknownHostException {
        return getResponse0();
    }
    @GetMapping(path = "/{cualquier}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, String> helloWorld2(@PathVariable(value = "cualquier") String cualquier) throws UnknownHostException {
        return getResponse2();
    }

    private Map<String, String> getResponse() throws UnknownHostException {

        Map<String, String> response = new HashMap<>();
        response.put(MESSAGE_KEY, "Hello World!");
        response.put("day & time", getCurrentTimeUsingDate());
        
        return response;
    }
    
    private Map<String, String> getResponse0() throws UnknownHostException {

        Map<String, String> response = new HashMap<>();
        response.put(MESSAGE_KEY, "gracias por tu ayuda, cabrecri@gmail.com");
     
        
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
	

}
