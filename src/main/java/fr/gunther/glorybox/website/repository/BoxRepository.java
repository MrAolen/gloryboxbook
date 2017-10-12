package fr.gunther.glorybox.website.repository;

import fr.gunther.glorybox.website.entity.Box;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxRepository extends JpaRepository<Box, Long> {
}
