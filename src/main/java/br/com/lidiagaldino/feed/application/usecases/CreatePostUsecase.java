package br.com.lidiagaldino.feed.application.usecases;

import br.com.lidiagaldino.feed.application.dto.CreatePostDto;
import br.com.lidiagaldino.feed.domain.entities.Post;
import io.smallrye.mutiny.Uni;

public interface CreatePostUsecase {
    Uni<Post> execute(CreatePostDto post);
}
