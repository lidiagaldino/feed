package br.com.lidiagaldino.feed.application.usecases.impl;

import br.com.lidiagaldino.feed.application.usecases.FindPostByAuthorUsecase;
import br.com.lidiagaldino.feed.domain.entities.Post;
import br.com.lidiagaldino.feed.domain.repositories.PostRepository;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FindPostByAuthorUsecaseImpl implements FindPostByAuthorUsecase {

    private final PostRepository postRepository;

    public FindPostByAuthorUsecaseImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Multi<Post> execute(String author) {
        return postRepository.findByAuthor(author);
    }
}
