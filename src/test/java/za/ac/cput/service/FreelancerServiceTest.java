package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Freelancer;
import za.ac.cput.factory.FreelancerFactory;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest

public class FreelancerServiceTest {

        @Autowired
        private FreelancerService service;
        private static Freelancer freelancer = FreelancerFactory.createFreelancer("Lonwabo","Magazi","Pretoria" , 100);
        @Test
        void a_create(){
            Freelancer created = service.create(freelancer);
            assertEquals(freelancer.getFreelancerId(),created.getFreelancerId());
            System.out.println("Created: "+created);
        }
        @Test
        void b_read(){
            Freelancer read = service.read(freelancer.getFreelancerId());
            assertNotNull(read);
            System.out.println("Read: "+read);
        }
        @Test
        void c_update() {
            Freelancer newFreelancer = new Freelancer.Builder().copy(freelancer).setFirstName("Mncedi").build();
            Freelancer updated = service.update(newFreelancer);
            assertEquals(newFreelancer.getFirstName(),updated.getFirstName());
            System.out.println("Updated: "+updated);
        }

        @Test
        @Disabled
        void e_delete() {

        }

        @Test
        void d_getAll() {
            System.out.println("Get All: ");
            System.out.println(service.getAll());
        }

    }
