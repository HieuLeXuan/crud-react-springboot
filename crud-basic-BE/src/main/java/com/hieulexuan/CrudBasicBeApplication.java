package com.hieulexuan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hieulexuan.model.Tutorial;
import com.hieulexuan.repository.TutorialRepository;

@SpringBootApplication
public class CrudBasicBeApplication implements CommandLineRunner {

	@Autowired
	private TutorialRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudBasicBeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tutorial tutorial = new Tutorial("title 1", "description 1", true);
		Tutorial tutorial1 = new Tutorial("title 2", "description 2", false);
		Tutorial tutorial2 = new Tutorial("title 3", "description 3", false);

		employeeRepository.save(tutorial);
		employeeRepository.save(tutorial1 );
		employeeRepository.save(tutorial2);
	}

}
