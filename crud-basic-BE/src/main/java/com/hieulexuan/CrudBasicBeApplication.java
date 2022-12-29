package com.hieulexuan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hieulexuan.model.Employee;
import com.hieulexuan.repository.EmployeeRepository;

@SpringBootApplication
public class CrudBasicBeApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudBasicBeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee("Le", "Hieu", "hieu@gmail.com");
		Employee employee1 = new Employee("Le", "Nghia", "nghia@gmail.com");
		Employee employee2 = new Employee("Nguyen", "Thao", "thao@gmail.com");

		employeeRepository.save(employee);
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
	}

}
