package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.ContactType;

@Repository
public interface ContactTypeRepository extends JpaRepository<ContactType, String> {
}
