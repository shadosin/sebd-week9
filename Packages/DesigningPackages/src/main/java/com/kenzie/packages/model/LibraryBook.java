package com.kenzie.packages.model;

/*
Properties
 * `String isbn`
 * `String subjectList`

Constructors
* `LibraryBook()`
* `LibraryBook(String title, String author)`

Methods
* a public `setBookInfo()` method
    * Acts like a setter
    * It will take in a responseString
    * Assign values to all relevant properties.
* override the `toString()` method
* public getter/setter methods for all the properties


The Response String Format
title|author|isbn|[subject]

ex -
The Art of War|Sun Tzu|9781780282992|[Military art and science, early works to 1800]
 */


public class LibraryBook extends Book {
    private String isbn;
    private String subjectList;

    public LibraryBook(){
        super();
        this.isbn = "";
        this.subjectList= "";
    }
    public LibraryBook(String title, String author){
        super(title, author);
        this.isbn = "";
        this.subjectList = "";

    }



    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(String subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "LibraryBook{" + "title='" + title +
                "', author='" + author +
                "', isbn='" + isbn +
                "', subjectList='" + subjectList +
                "'}";
    }

    @Override
    public void setBookInfo(String responseString) {
        String[] parts = responseString.split("\\|");
        this.setTitle(parts[0]);
        this.setAuthor(parts[1]);
        this.isbn = parts[2];
        this.subjectList = parts[3].replaceAll("\\|", "");

    }
}