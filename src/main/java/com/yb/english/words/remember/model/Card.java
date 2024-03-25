package com.yb.english.words.remember.model;

import com.yb.english.words.remember.entity.Word;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@ToString
public class Card {
    private Word answer;
    private String question;
    private List<Word> options;

    public Card(List<Word> words) {
        this.answer = words.get(0);
        this.question = "What is the translation of the word: " + answer.getWord() + "?";
        this.options = words;
        shuffleOptions();
    }
    private void shuffleOptions(){
        List<Word> shuffledOptions = options;
        Collections.shuffle(shuffledOptions);
        setOptions(shuffledOptions);
    }

}
