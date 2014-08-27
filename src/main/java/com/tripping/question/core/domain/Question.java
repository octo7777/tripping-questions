package com.tripping.question.core.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Question {
    @Id
    private BigInteger id;

    @DBRef
    private User author;

    private String content;
    private List<Answer> answers = new ArrayList<Answer>();
    private Answer best;

    public Question(User author, String content) {
        this.author = author;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Answer getBest() {
        return best;
    }

    public void setBest(Answer best) {
        this.best = best;
    }

    public BigInteger getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
