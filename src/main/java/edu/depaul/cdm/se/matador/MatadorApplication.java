package edu.depaul.cdm.se.matador;

import edu.depaul.cdm.se.matador.model.Role;
import edu.depaul.cdm.se.matador.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MatadorApplication implements CommandLineRunner {

	@Autowired
	RestTemplate restTemplate;


	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(MatadorApplication.class, args);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}//end main

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}//todo: is this the correct format?

	@Override
	public void run(String... args)  {
//		INSTRUCTOR
//		MEMBER
//		ADMIN
		Role role = new Role();
		role.setRoleName("SYS_ADMIN");
		role.setPriority(1L);
		this.roleService.createRole(role);

		role.setRoleName("ADMIN");
		role.setPriority(2L);
		this.roleService.createRole(role);

		role.setRoleName("INSTRUCTOR");
		role.setPriority(3L);
		this.roleService.createRole(role);

		role.setRoleName("MEMBER");
		role.setPriority(4L);
		this.roleService.createRole(role);

	}//end run
}
