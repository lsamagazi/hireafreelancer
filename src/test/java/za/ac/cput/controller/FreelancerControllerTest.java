package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Freelancer;
import za.ac.cput.factory.FreelancerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class FreelancerControllerTest {

    private static Freelancer freelancer = FreelancerFactory.createFreelancer("Kruben"," Naidoo","Cape Town",50);

        @Autowired
        private TestRestTemplate restTemplate;
        private final String baseURL ="http://localhost:8080/employee";

        @Test
        void a_create(){
            String url = baseURL +"/create";
            ResponseEntity<Freelancer> postResponse = restTemplate.postForEntity(url,freelancer,Freelancer.class);
            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());

            Freelancer savedEmployee=postResponse.getBody();
            System.out.println("Saved Data: " +"savedEmployee");
            assertEquals(freelancer.getFreelancerId(),savedEmployee.getFreelancerId());
        }
        @Test
        void b_read() {
            String url = baseURL + "/read/" + freelancer.getFreelancerId();
            System.out.println("URL: " + url);
            ResponseEntity<Freelancer> response = restTemplate.getForEntity(url, Freelancer.class);
            assertEquals(freelancer.getFreelancerId(), response.getBody().getFreelancerId());
            System.out.println(response.getBody());
        }
        @Test
        void c_update(){
            Freelancer updated = new Freelancer.Builder().copy(freelancer).setFirstName("Lonwabo").setLastName("Magazi").setCity("Pretoria").build();
            String url = baseURL +"/update/";
            System.out.println("URL: "+url);
            System.out.println("Post data: " +updated);
            ResponseEntity<Freelancer>response = restTemplate.postForEntity(url,updated,Freelancer.class);
            assertNotNull(response.getBody());
        }
        @Test
        @Disabled
        void e_delete(){
            String url = baseURL + "/delete/"+freelancer.getFreelancerId();
            System.out.println("URL: "+url);
            restTemplate.delete(url);
        }
        @Test
        void d_getall(){
            String url = baseURL +"/getall/";
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity=new HttpEntity<>(null,headers);
            ResponseEntity<String>response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
            System.out.printf("Show ALL: ");
            System.out.println(response);
            System.out.println(response.getBody());
        }
    }

