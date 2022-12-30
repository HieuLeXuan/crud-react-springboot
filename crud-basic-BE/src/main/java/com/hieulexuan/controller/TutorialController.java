package com.hieulexuan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hieulexuan.model.Tutorial;
import com.hieulexuan.service.TutorialService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class TutorialController {

	@Autowired
	private TutorialService tutorialService;

	// get all tutorial
	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			List<Tutorial> tutorials = new ArrayList<>();
			if (title == null) {
				tutorialService.findAll().forEach(tutorials::add);
			} else {
				tutorialService.findByTitleContaining(title).forEach(tutorials::add);
			}

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// get tutorials by id
	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
		Optional<Tutorial> tutorialData = tutorialService.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<Tutorial>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Tutorial>(HttpStatus.NOT_FOUND);
		}
	}

	// create tutorial
	@PostMapping("/tutorials")
	public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
		try {
			Tutorial _tutorial = tutorialService
					.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
			return new ResponseEntity<>(_tutorial, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// update tutorial by id
	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
		// find tutorial data by id initial
		Optional<Tutorial> tutorialData = tutorialService.findById(id);

		// if have tutorial data in db, set data into
		if (tutorialData.isPresent()) {
			Tutorial _tutorial = tutorialData.get();
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setPublished(tutorial.getPublished());
			return new ResponseEntity<>(tutorialService.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// delete tutorial by id
	@DeleteMapping("tutorials/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			tutorialService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// delete all tutorials
	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			tutorialService.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// get tutorials by published
	@GetMapping("/tutorial/published")
	public ResponseEntity<List<Tutorial>> findByPublished() {
		try {
			List<Tutorial> tutorials = tutorialService.findByPublished(true);
			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
