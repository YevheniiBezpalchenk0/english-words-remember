package com.yb.english.words.remember.controller;

import com.yb.english.words.remember.model.Card;
import com.yb.english.words.remember.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/cards")
    public Card getCards(){
        return testService.createCardTest(4);
    }
}
