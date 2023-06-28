package za.ac.cput.controller;

/**
 * FreelancerController.java
 * Author: Lonwabo Sibusisiwe Magazi- 218331851
 * Date: May 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Freelancer;
import za.ac.cput.service.IFreelancerService;

import java.util.List;

@RestController
@RequestMapping("/freelancer")
public class FreelancerController {
    private final IFreelancerService freelancerService;

    @Autowired
    public FreelancerController(IFreelancerService FreelancerService) {
        this.freelancerService = FreelancerService;
    }

    @PostMapping("/create")
    public Freelancer create(@RequestBody Freelancer freelancer) {
        return freelancerService.create(freelancer);
    }

    @GetMapping("/read/{id}")
    public Freelancer read(@PathVariable String id) {
        return freelancerService.read(id);
    }

    @PostMapping("/update")
    public Freelancer update(@RequestBody Freelancer freelancer) {
        return freelancerService.update(freelancer);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return freelancerService.delete(id);
    }

    @GetMapping("/getall")
    public List<Freelancer> getAll() {
        return freelancerService.getAll();
    }
}
