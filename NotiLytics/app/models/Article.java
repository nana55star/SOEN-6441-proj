package models;

public class Article {
    public String title;
    public String description;
    public String url;
    public String sourceName;

    public Article(String title, String description, String url, String sourceName) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.sourceName = sourceName;
    }
}

