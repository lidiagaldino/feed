package br.com.lidiagaldino.feed.application.usecases.impl;

import br.com.lidiagaldino.feed.application.usecases.FindAllPostsUsecase;
import br.com.lidiagaldino.feed.domain.entities.Post;
import br.com.lidiagaldino.feed.domain.repositories.PostRepository;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FindAllPostsUsecaseImpl implements FindAllPostsUsecase {

    @Inject
    private final PostRepository postRepository;

    public FindAllPostsUsecaseImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Multi<Post> execute() {
        return postRepository.findAll();
    }
}
