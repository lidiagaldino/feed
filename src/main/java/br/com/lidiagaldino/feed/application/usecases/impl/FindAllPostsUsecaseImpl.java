package br.com.lidiagaldino.feed.application.usecases.impl;

import br.com.lidiagaldino.feed.application.usecases.FindAllPostsUsecase;
import br.com.lidiagaldino.feed.domain.entities.TranslatedPost;
import br.com.lidiagaldino.feed.domain.exceptions.NotFoundException;
import br.com.lidiagaldino.feed.domain.repositories.PostRepository;
import br.com.lidiagaldino.feed.domain.services.TranslationService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FindAllPostsUsecaseImpl implements FindAllPostsUsecase {

    @Inject
    private final PostRepository postRepository;
    private final TranslationService translationService;

    public FindAllPostsUsecaseImpl(PostRepository postRepository, TranslationService translationService) {
        this.postRepository = postRepository;
        this.translationService = translationService;
    }

    @Override
    public Multi<TranslatedPost> execute(String language) {
        return postRepository.findAll()
                .onCompletion().ifEmpty().failWith(new NotFoundException("POST_NOT_FOUND"))
                .flatMap(i -> translationService.translate(i.getContent(), language)
                        .onItem().transform(translatedContent -> new TranslatedPost(i, translatedContent)).toMulti()
                );
    }
}
