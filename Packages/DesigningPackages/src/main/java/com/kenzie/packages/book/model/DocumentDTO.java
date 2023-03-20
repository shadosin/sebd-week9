package com.kenzie.packages.book.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentDTO {

    @com.fasterxml.jackson.annotation.JsonProperty("subject")
    private java.util.List<String> subject;
    @com.fasterxml.jackson.annotation.JsonProperty("person")
    private java.util.List<String> person;
    @com.fasterxml.jackson.annotation.JsonProperty("author_name")
    private java.util.List<String> authorName;
    @com.fasterxml.jackson.annotation.JsonProperty("isbn")
    private java.util.List<String> isbn;
    @com.fasterxml.jackson.annotation.JsonProperty("title")
    private String title;

    public List<String> getSubject() {
        return subject;
    }

    public List<String> getAuthorName() {
        return authorName;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getIsbn() {
        return isbn;
    }


}