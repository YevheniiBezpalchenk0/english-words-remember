package com.yb.english.words.remember.service;


import com.yb.english.words.remember.entity.Word;
import com.yb.english.words.remember.repo.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {

    private final WordRepo wordRepo;

    @Autowired
    public WordService(WordRepo wordRepo) {
        this.wordRepo = wordRepo;
    }

    public List<Word> getLowKnowledgeWords(int knowledge) {
        return wordRepo.findAllByKnowledgeLessThanEqualOrderByKnowledgeAsc(knowledge);
    }
    public List<Word> getAllWords() {
        return wordRepo.findAll();
    }

    public Optional<Word> getWordById(Long id) {
        return wordRepo.findById(id);
    }
    public Word saveWord(Word word) {
        word.setWord(word.getWord().toLowerCase());
        word.setTranslate(word.getTranslate().toLowerCase());
        return wordRepo.save(word);
    }

    public void deleteWord(Long id) {
        wordRepo.deleteById(id);
    }
}