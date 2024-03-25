package com.yb.english.words.remember.service;

import com.yb.english.words.remember.entity.Word;
import com.yb.english.words.remember.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TestService {
    private final WordService wordService;

    @Autowired
    public TestService(WordService wordService) {
        this.wordService = wordService;
    }

    public Card createCardTest(int wordsCount) {
        return new Card(filterWords(wordsCount));
    }
    private List<Word> filterWords(int wordsCount){
        List<Word> shuffledWords = new ArrayList<>();
        List<Word> lowKnowledgeWords = wordService.getLowKnowledgeWords(50);
        List<Word> otherWords = wordService.getAllWords();
        otherWords.removeAll(lowKnowledgeWords);

        Collections.shuffle(lowKnowledgeWords);
        Collections.shuffle(otherWords);
        for(int i = 0; i < wordsCount; i++){
            if(i < lowKnowledgeWords.size() || i < wordsCount / 2){
                shuffledWords.add(lowKnowledgeWords.get(i));
            } else {
                shuffledWords.add(otherWords.get(i - lowKnowledgeWords.size()));
            }
        }
        return shuffledWords;
    }
}
