package fr.gunther.glorybox.website.repository;

import fr.gunther.glorybox.website.entity.StaticData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaticDataRepository extends JpaRepository<StaticData, Long> {

    StaticData findByKey(String key);
}
