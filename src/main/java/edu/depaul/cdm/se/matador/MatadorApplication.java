package edu.depaul.cdm.se.matador;

import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.model.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MatadorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MatadorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Session session = new Session();
		session.getMember();
		session.setMember(new Member());
	}
}
