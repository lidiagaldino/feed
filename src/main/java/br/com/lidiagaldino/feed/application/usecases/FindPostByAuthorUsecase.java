package br.com.lidiagaldino.feed.application.usecases;

import br.com.lidiagaldino.feed.domain.entities.Post;
import io.smallrye.mutiny.Multi;

public interface FindPostByAuthorUsecase {
    Multi<Post> execute(String author);
}
