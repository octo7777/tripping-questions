package com.tripping.question.core.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Answer {
    @DBRef
    private User author;

    private String content;

    public Answer(User author, String content) {
        this.author = author;
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
