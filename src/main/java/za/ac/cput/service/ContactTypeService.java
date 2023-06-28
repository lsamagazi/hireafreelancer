package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ContactType;
import za.ac.cput.repository.ContactTypeRepository;

import java.util.List;

@Service
public class ContactTypeService implements IContactTypeService {
    private ContactTypeRepository repository;

    @Autowired
    public ContactTypeService(ContactTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ContactType create(ContactType contactType) {
        return repository.save(contactType);
    }

    @Override
    public ContactType read(String contactId) {
        return repository.findById(contactId).orElse(null);
    }

    @Override
    public ContactType update(ContactType contactType) {
        if (repository.existsById(contactType.getContactId())) {
            return repository.save(contactType);
        }
        return null;
    }

    @Override
    public boolean delete(String contactId) {
        if (repository.existsById(contactId)) {
            repository.deleteById(contactId);
            return true;
        }
        return false;
    }

    @Override
    public List<ContactType> getAll() {
        return repository.findAll();
    }
}
