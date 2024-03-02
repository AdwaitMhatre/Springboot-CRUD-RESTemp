package net.javacrud.springboot;

import net.javacrud.springboot.model.Employee;
import net.javacrud.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCrudbackendApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudbackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Employee employee1 = new Employee();
//		employee1.setFirstName("Adwait");
//		employee1.setLastName("Mhatre");
//		employee1.setEmailId("adwaitmhatre123@gmail.com");
//		employeeRepository.save(employee1);
//
//		Employee employee2 = new Employee();
//		employee2.setFirstName("Ayush");
//		employee2.setLastName("Sarve");
//		employee2.setEmailId("ayushsarve123@gmail.com");
//		employeeRepository.save(employee2);
	}
}
