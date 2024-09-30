package br.com.lidiagaldino.feed.application.usecases;

import br.com.lidiagaldino.feed.domain.entities.Post;
import br.com.lidiagaldino.feed.domain.entities.TranslatedPost;
import io.smallrye.mutiny.Multi;

public interface FindPostByAuthorUsecase {
    Multi<TranslatedPost> execute(String author, String language);
}
