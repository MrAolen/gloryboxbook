package fr.gunther.glorybox.website.repository;

import fr.gunther.glorybox.website.dto.CommandDTO;
import fr.gunther.glorybox.website.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandRepository extends JpaRepository<Command, Long> {
    List<Command> findByStatus(Command.Status archived);
}
