package za.ac.cput.service;

import za.ac.cput.domain.ContactType;
import java.util.List;

public interface IContactTypeService {
    ContactType create(ContactType contactType);
    ContactType read(String contactTypeId);
    ContactType update(ContactType contactType);
    boolean delete(String contactTypeId);
    List<ContactType> getAll();
}
