package za.ac.cput.controller;

/**
 * ContactTypeController.java
 * Author: Lonwabo Sibusisiwe Magazi- 218331851
 * Date: 28/06/2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ContactType;
import za.ac.cput.service.IContactTypeService;

import java.util.List;

@RestController
@RequestMapping("/contact-type")
public class ContactTypeController {
    private final IContactTypeService contactTypeService;

    @Autowired
    public ContactTypeController(IContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @PostMapping("/create")
    public ContactType create(@RequestBody ContactType contactType) {
        return contactTypeService.create(contactType);
    }

    @GetMapping("/read/{id}")
    public ContactType read(@PathVariable String id) {
        return contactTypeService.read(id);
    }

    @PostMapping("/update")
    public ContactType update(@RequestBody ContactType contactType) {
        return contactTypeService.update(contactType);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return contactTypeService.delete(id);
    }

    @GetMapping("/get-all")
    public List<ContactType> getAll() {
        return contactTypeService.getAll();
    }
}
