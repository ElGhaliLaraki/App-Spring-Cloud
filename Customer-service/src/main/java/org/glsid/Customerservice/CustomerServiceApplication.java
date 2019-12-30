package org.glsid.Customerservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Data @ToString @NoArgsConstructor @AllArgsConstructor
class Customer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String name;
}
@RepositoryRestResource
interface CustomerRepository extends JpaRepository <Customer,Long>{}

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null,"ghalilaaraki@gmail.com","El Ghali"));
			customerRepository.save(new Customer(null,"mehdilaaraki@gmail.com","El Mehdi"));
			customerRepository.save(new Customer(null,"Abdesselamlaaraki@gmail.com","Abdesselam"));
			customerRepository.findAll().forEach(System.out::println);

		};
	}

}
