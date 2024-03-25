package com.yb.english.words.remember.repo;

import com.yb.english.words.remember.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepo extends JpaRepository<Word, Long> {

    List<Word> findAllByKnowledgeLessThanEqualOrderByKnowledgeAsc(int knowledge);
}
