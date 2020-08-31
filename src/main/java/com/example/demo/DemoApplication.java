package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class DemoApplication {
	
	@Autowired(required=true)
	UserRepo userrepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	userrepo.save(new User("Dileep", "admin", "dilep@gmail.com", "0123456789", "javadev", "lose"));
	    	userrepo.save(new User("mani", "user", "mani@gmail.com", "0123456789", "javadev", "lose"));
	    	userrepo.save(new User("jhon", "teacher", "jhon@gmail.com", "0123456789", "javadev", "lose"));
	    	userrepo.save(new User("raj", "staff", "raj@gmail.com", "0123456789", "javadev", "lose"));
	    	userrepo.save(new User("sarath", "admin", "sarath@gmail.com", "0123456789", "javadev", "lose"));
	    	userrepo.save(new User("ashok", "user", "ashok@gmail.com", "0123456789", "javadev", "lose"));
	    	userrepo.save(new User("anil", "staff", "anil@gmail.com", "0123456789", "javadev", "lose"));
	    	userrepo.save(new User("pavan", "admin", "pavan@gmail.com", "0123456789", "javadev", "lose"));
	    	userrepo.save(new User("hari", "user", "hari@gmail.com", "0123456789", "javadev", "lose"));
	    	userrepo.save(new User("ramu", "user", "ramu@gmail.com", "0123456789", "javadev", "lose"));
	    	
	    	
	      };
	   }

}
