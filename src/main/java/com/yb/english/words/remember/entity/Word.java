package com.yb.english.words.remember.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    private String translate;
    private String sentence;
    private int knowledge;
    public void setKnowledge(int knowledge) {
        if (knowledge >= 0 && knowledge <= 100) {
            this.knowledge = knowledge;
        } else {
            if (knowledge < 0) {
                this.knowledge = 0;
            } else {
                this.knowledge = 100;
            }
        }
    }
}
