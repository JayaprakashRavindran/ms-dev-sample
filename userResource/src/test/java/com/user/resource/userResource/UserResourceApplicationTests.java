package com.user.resource.userResource;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.user.resource.userResource.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserResourceApplicationTests {

    public static final String REST_SERVICE_URI = "http://localhost:8080/users";
    
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        System.out.println("Testing Step 01-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/users/", List.class);
         
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Status="+map.get("status"));
            }
        }else{
            System.out.println(" User does not exist----------");
        }
    }
    
    private static void getUser(){
        System.out.println("Testing getUser Step 01----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI+"/users/01", User.class);
        System.out.println(user);
    }
    /* POST */
    private static void createUser() {
        System.out.println("Testing create User Step 03----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User("04","Sarah","SoftwareEx");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/users/", user, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

 
}
