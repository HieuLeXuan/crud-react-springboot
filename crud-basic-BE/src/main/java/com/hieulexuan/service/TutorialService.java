package com.hieulexuan.service;

import java.util.List;
import java.util.Optional;

import com.hieulexuan.model.Tutorial;

public interface TutorialService {

	List<Tutorial> findAll();

	List<Tutorial> findByPublished(boolean published);

	List<Tutorial> findByTitleContaining(String title);

	Optional<Tutorial> findById(long id);

	Tutorial save(Tutorial tutorial);

	void deleteById(long id);

	void deleteAll();

}
