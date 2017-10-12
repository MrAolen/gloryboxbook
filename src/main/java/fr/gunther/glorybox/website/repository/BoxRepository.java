package fr.gunther.glorybox.website.repository;

import fr.gunther.glorybox.website.entity.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {
    Box findFirstByOrderByCreationDateDesc();
}
