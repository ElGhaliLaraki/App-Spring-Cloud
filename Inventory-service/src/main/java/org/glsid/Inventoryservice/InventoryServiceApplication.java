package org.glsid.Inventoryservice;

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

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
}
@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product,Long>{}


@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
			productRepository.save(new Product(null,"Computer HP 650",3600));
			productRepository.save(new Product(null,"Computer DELL XPS",20000));
			productRepository.save(new Product(null,"Imprimante",1500));
			productRepository.findAll().forEach(System.out::println);

		};
	}

}
