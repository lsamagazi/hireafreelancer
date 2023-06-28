package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Freelancer;
import static org.junit.jupiter.api.Assertions.*;

public class FreelancerFactoryTest {

        @Test
        public void test(){
            Freelancer employee =FreelancerFactory.createFreelancer("Kruben"," Naidoo","Cape Town", 50);
            System.out.println(employee.toString());
            assertNotNull(employee);
        }

    }

