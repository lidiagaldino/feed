package br.com.lidiagaldino.feed.application.usecases.impl;

import br.com.lidiagaldino.feed.application.dto.CreatePostDto;
import br.com.lidiagaldino.feed.application.usecases.CreatePostUsecase;
import br.com.lidiagaldino.feed.domain.entities.Post;
import br.com.lidiagaldino.feed.domain.repositories.PostRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;

@ApplicationScoped
public class CreatePostUsecaseImpl implements CreatePostUsecase {

    @Inject
    private final PostRepository postRepository;

    public CreatePostUsecaseImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Uni<Post> execute(CreatePostDto postDto) {
        Post post = new Post(postDto.content(), postDto.author());
        return postRepository.create(post);
    }
}
