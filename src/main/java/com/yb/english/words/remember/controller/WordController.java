package com.yb.english.words.remember.controller;

import com.yb.english.words.remember.entity.Word;
import com.yb.english.words.remember.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public List<Word> getAllWords() {
        return wordService.getAllWords();
    }

    @GetMapping("/{id}")
    public Word getWordById(@PathVariable Long id) {
        return wordService.getWordById(id)
                .orElseThrow(() -> new RuntimeException("Word not found with id: " + id));
    }

    @PostMapping
    public Word saveWord(@RequestBody Word word) {
        return wordService.saveWord(word);
    }

    @PutMapping("/learn/{id}")
    public Word updateWordKnowledge(@PathVariable Long id, @RequestBody Word updatedWord) {
        Word existingWord = wordService.getWordById(id)
                .orElseThrow(() -> new RuntimeException("Word not found with id: " + id));

        System.out.println("by id" + existingWord);

        System.out.println("by body " +updatedWord);
        if(existingWord.getId().equals(updatedWord.getId())){
                existingWord.setKnowledge(existingWord.getKnowledge() + 1);
        } else {
                existingWord.setKnowledge(existingWord.getKnowledge() - 3);
        }
        System.out.println("knowledge answer: " + existingWord.getKnowledge());
        return wordService.saveWord(existingWord);
    }
    @PutMapping("/{id}")
    public Word updateWord(@PathVariable Long id, @RequestBody Word updatedWord) {
        Word existingWord = wordService.getWordById(id)
                .orElseThrow(() -> new RuntimeException("Word not found with id: " + id));

        existingWord.setWord(updatedWord.getWord());
        existingWord.setTranslate(updatedWord.getTranslate());
        existingWord.setSentence(updatedWord.getSentence());
        existingWord.setKnowledge(updatedWord.getKnowledge());

        return wordService.saveWord(existingWord);
    }

    @DeleteMapping("/{id}")
    public void deleteWord(@PathVariable Long id) {
        wordService.deleteWord(id);
    }
}