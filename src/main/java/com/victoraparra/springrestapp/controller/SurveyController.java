package com.victoraparra.springrestapp.controller;

import com.victoraparra.springrestapp.model.Question;
import com.victoraparra.springrestapp.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    private SurveyService service;

    // GET -Retrieve details of a resource
    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestionsForSurvey(@PathVariable String surveyId){
        return service.retrieveQuestions(surveyId);
    }

    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveDetailsForQuestion(@PathVariable String surveyId, @PathVariable String questionId){
        return service.retrieveQuestion(surveyId, questionId);
    }

    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<Void> addQuestionToSurvey(@PathVariable String surveyId, @RequestBody Question newQuestion){
        // What should be structure of request body?
        // How will it be mapped to Question object? - whit the @RequestBody anotation
        // What should be returned?
        // what shoul be response status
        Question question = service.addQuestion(surveyId, newQuestion);

        if (question == null){
            return ResponseEntity.noContent().build();
        }
        // Success - URI of the new resource in Response Header
        // Status - created
        //URI -> /surveys/{surveyId}/questions/{questionId} question.getQuestionID()
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(question.getId()).toUri();

        // Status
        return ResponseEntity.created(location).build();
    }
}
