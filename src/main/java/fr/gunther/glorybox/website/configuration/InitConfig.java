package fr.gunther.glorybox.website.configuration;

import fr.gunther.glorybox.website.entity.Box;
import fr.gunther.glorybox.website.entity.CountryDelivery;
import fr.gunther.glorybox.website.entity.StaticData;
import fr.gunther.glorybox.website.entity.User;
import fr.gunther.glorybox.website.repository.BoxRepository;
import fr.gunther.glorybox.website.repository.CountryDeliveryRepository;
import fr.gunther.glorybox.website.repository.StaticDataRepository;
import fr.gunther.glorybox.website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Date;

@Configuration
public class InitConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoxRepository boxRepository;

    @Autowired
    private StaticDataRepository staticDataRepository;

    @Autowired
    private CountryDeliveryRepository countryDeliveryRepository;

    @PostConstruct
    public void initData() {
       /* BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");

        User user = new User();
        user.setEmail("gunthernic@eisti.eu");
        user.setActive(1);
        user.setPassword(hashedPassword);
        userRepository.save(user);

        Box box = new Box();
        box.setCreationDate(new Date());
        box.setName("Box Normal");
        box.setPrice(24.0F);
        boxRepository.save(box);

        Box box2 = new Box();
        box2.setCreationDate(new Date());
        box2.setName("Petite Box");
        box2.setPrice(12.5F);
        boxRepository.save(box2);

        StaticData staticData = new StaticData();
        staticData.setLabel("description oiahefahzfpef");
        staticData.setKey("description");
        staticDataRepository.save(staticData);

        CountryDelivery france = new CountryDelivery();
        france.setCountry("France");
        france.setPrice(55F);
        countryDeliveryRepository.save(france);

        CountryDelivery outre_mer_france = new CountryDelivery();
        outre_mer_france.setCountry("France Outre Mer");
        outre_mer_france.setPrice(60F);
        countryDeliveryRepository.save(outre_mer_france);

        CountryDelivery canada = new CountryDelivery();
        canada.setCountry("Canada");
        canada.setPrice(65F);
        countryDeliveryRepository.save(canada);

        CountryDelivery belgique = new CountryDelivery();
        belgique.setCountry("Belgique");
        belgique.setPrice(70F);
        countryDeliveryRepository.save(belgique);

        CountryDelivery luxembourg = new CountryDelivery();
        luxembourg.setCountry("Luxembourg");
        luxembourg.setPrice(75F);
        countryDeliveryRepository.save(luxembourg);

	    CountryDelivery depot = new CountryDelivery();
        depot.setCountry("Au Depot");
        depot.setPrice(0F);
        countryDeliveryRepository.save(depot);*/
    }

}
