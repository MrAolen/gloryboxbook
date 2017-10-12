package fr.gunther.glorybox.website.repository;

import fr.gunther.glorybox.website.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Long> {
}
