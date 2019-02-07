package com.justin.overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.justin.overflow.models.Answer;
import com.justin.overflow.models.Question;
import com.justin.overflow.models.Tag;
import com.justin.overflow.services.MyService;

@Controller
public class MyController {

	private final MyService service;

	public MyController(MyService service) {
		this.service = service;
	}

//	ALL QUESTIONS	
	@GetMapping("/questions")
	public String display(Model model) {
		List<Question> questions = service.allQuestions();
		model.addAttribute("questions", questions);
		return "questions.jsp";
	}

//	QUESTION INFO
	@GetMapping("/questions/{id}")
	public String info(Model model, @PathVariable("id") Long id, @Valid @ModelAttribute("newAnswer") Answer newAnswer) {
		Question question = service.findQuestionById(id);
		model.addAttribute("question", question);
		return "questinfo.jsp";
	}

//	ANSWER QUESTION
	@PostMapping("/questions/{id}")
	public String answer(@PathVariable("id") Long id, @Valid @ModelAttribute("newAnswer") Answer newAnswer,
			BindingResult result, Model model) {
		Question question = service.findQuestionById(id);
		if (result.hasErrors()) {
			model.addAttribute("question", question);
			return "/questinfo.jsp";
		} else {
			newAnswer.setQuestion(question);
			service.createAnswer(newAnswer);
			return "redirect:/questions/" + id;
		}
	}

//	QUESTION PAGE
	@GetMapping("/questions/new")
	public String newQ() {
		return "newquest.jsp";
	}

//	POST QUESTION AND TAG
	@PostMapping("/questions/new")
	public String postQ(@RequestParam("question") String question, @RequestParam("tags") String tags) {

		if (question.length() < 1) {
			return "redirect:/questions/new";
		}

		Question newQuestion = new Question(question);

		String[] tagsList = tags.split(",");
		if (tagsList.length > 3) {
			return "redirect:/questions/new";
		}
		List<Tag> tagArray = new ArrayList<>();
		for (String tag : tagsList) {
			Tag newTag;
			if (service.findTagBySubject(tag) == null) {
				newTag = new Tag(tag);
				service.saveTag(newTag);
				newTag = service.findTagById(newTag.getId());
			} else {
				newTag = service.findTagBySubject(tag);
			}
			tagArray.add(newTag);
		}
		newQuestion.setTags(tagArray);
		service.saveQuestion(newQuestion);
		return "redirect:/questions";
	}

}
