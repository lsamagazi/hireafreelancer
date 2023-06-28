package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Freelancer;
import za.ac.cput.repository.FreelancerRepository;

import java.util.List;
@Service
public class FreelancerService implements IFreelancerService{
    private FreelancerRepository repository;
    @Autowired
    private FreelancerService(FreelancerRepository repository){
        this.repository = repository;
    }
    @Override
    public Freelancer create(Freelancer freelancer) {
        return this.repository.save(freelancer);
    }

    @Override
    public Freelancer read(String freelancerId) {
        return this.repository.findById(freelancerId).orElse(null);
    }

    @Override
    public Freelancer update(Freelancer freelancer) {
        if(this.repository.existsById(freelancer.getFreelancerId())){
            return this.repository.save(freelancer);
        }
        return null;
    }

    @Override
    public boolean delete(String freelancerId) {
        if (this.repository.existsById(freelancerId)){
            this.repository.deleteById(freelancerId);
            return true;
        }
        return false;
    }

    @Override
    public List<Freelancer> getAll() {
        return this.repository.findAll();
    }
}