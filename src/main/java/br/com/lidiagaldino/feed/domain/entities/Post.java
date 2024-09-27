package br.com.lidiagaldino.feed.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import jakarta.persistence.Entity;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@MongoEntity(collection="post")
public class Post extends ReactivePanacheMongoEntity {
    private String content;
    private String author;
    private LocalDateTime date;

    public Post() {}

    public Post(String content, String author) {
        this.content = content;
        this.author = author;
        this.date = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
