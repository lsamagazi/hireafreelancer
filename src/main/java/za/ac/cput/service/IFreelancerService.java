package za.ac.cput.service;

import za.ac.cput.domain.Freelancer;
import java.util.List;
public interface IFreelancerService {

      Freelancer create (Freelancer employee);
        public Freelancer read(String employeeNumber);
        Freelancer update (Freelancer freelancer);
        boolean delete(String freelancerId);
        List<Freelancer> getAll();

    }
