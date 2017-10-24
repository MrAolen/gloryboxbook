package fr.gunther.glorybox.website;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsiteApplication {

	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(WebsiteApplication.class, args);
	}
}
