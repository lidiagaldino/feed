package br.com.lidiagaldino.feed.domain.entities;

import java.time.LocalDateTime;

public class TranslatedPost {
    private String content;
    private String translatedContent;
    private String author;
    private LocalDateTime date;

    public TranslatedPost(){}

    public TranslatedPost(Post post, String translation) {
      this.content = post.getContent();
      this.translatedContent = translation;
      this.author = post.getAuthor();
      this.date = post.getDate();
    }

    public String getContent() {
      return this.content;
    }

    public String getTranslatedContent() {
      return this.translatedContent;
    }

    public String getAuthor() {
      return this.author;
    }

    public LocalDateTime getDate() {
      return this.date;
    }
}
