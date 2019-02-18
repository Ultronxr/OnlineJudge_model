package com.oj.entity;

public class PoetrySubEntity {

    private int id;
    private String title;
    private String dynasty;
    private String author;
    private String content;
    private String ans;



    public PoetrySubEntity() {
    }

    public PoetrySubEntity(int id, String title, String dynasty, String author) {
        this.id = id;
        this.title = title;
        this.dynasty = dynasty;
        this.author = author;
    }

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

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "PoetrySubEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", ans='" + ans + '\'' +
                '}';
    }
}
