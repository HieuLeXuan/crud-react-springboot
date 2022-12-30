package com.hieulexuan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieulexuan.model.Tutorial;
import com.hieulexuan.repository.TutorialRepository;

@Service
public class TutorialServiceI implements TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;

	@Override
	public List<Tutorial> findAll() {
		return tutorialRepository.findAll();
	}

	@Override
	public List<Tutorial> findByPublished(boolean published) {
		// TODO Auto-generated method stub
		return tutorialRepository.findByPublished(published);
	}

	@Override
	public List<Tutorial> findByTitleContaining(String title) {
		// TODO Auto-generated method stub
		return tutorialRepository.findByTitleContaining(title);
	}

	@Override
	public Optional<Tutorial> findById(long id) {
		// TODO Auto-generated method stub
		return tutorialRepository.findById(id);
	}

	@Override
	public Tutorial save(Tutorial tutorial) {
		// TODO Auto-generated method stub
		return tutorialRepository.save(tutorial);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		tutorialRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		tutorialRepository.deleteAll();
	}

}
