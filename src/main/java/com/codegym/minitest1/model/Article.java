package com.codegym.minitest1.model;

import java.util.Date;

public class Article {
    private static int nextId = 1;

    private int id;
    private String title;
    private String content;
    private Date createdDate;

    public Article() {
        this.id = nextId++;
    }

    public Article(String title, String content, Date createdDate) {
        this.id = nextId++;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }

    // Getter and Setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
