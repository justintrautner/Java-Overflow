package com.justin.overflow.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.justin.overflow.models.Answer;
import com.justin.overflow.models.Question;
import com.justin.overflow.models.Tag;
import com.justin.overflow.repositories.AnswerRepository;
import com.justin.overflow.repositories.QuestionRepository;
import com.justin.overflow.repositories.TagRepository;

@Service
public class MyService {
	
	private final AnswerRepository ansRepo;
	private final QuestionRepository questRepo;
	private final TagRepository tagRepo;
	
	public MyService(AnswerRepository ansRepo,QuestionRepository questRepo,TagRepository tagRepo) {
		this.ansRepo=ansRepo;
		this.questRepo=questRepo;
		this.tagRepo=tagRepo;
	}
//	ALL QUESTIONS
	public List<Question> allQuestions() {
		return questRepo.findAll();
	}
//	FIND QUESTION BY ID
	public Question findQuestionById(Long id) {
		Optional<Question> question = questRepo.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			return null;
		}
	}
//	FIND TAG BY ID
	public Tag findTagById(Long id) {
		Optional<Tag> tag = tagRepo.findById(id);
		if(tag.isPresent()) {
			return tag.get();
		}else {
			return null;
		}
	}
//	CREATE ANSWER
	public Answer createAnswer(Answer newAnswer) {
		return ansRepo.save(newAnswer);
		
	}
//	FIND TAG BY SUBJECT
	public Tag findTagBySubject(String subject) {
		Optional<Tag> tag=tagRepo.findBySubject(subject);
		if(tag.isPresent()) {
			return tag.get();
		}else {
			return null;
		}
	}
//	SAVE TAG
	public void saveTag(Tag tag) {
		tagRepo.save(tag);
	}
//	SAVE QUESTION
	public void saveQuestion(Question question) {
		questRepo.save(question);
	}

}
