package fr.gunther.glorybox.website.repository;

import fr.gunther.glorybox.website.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressInterface extends JpaRepository<Address, Long> {
}
