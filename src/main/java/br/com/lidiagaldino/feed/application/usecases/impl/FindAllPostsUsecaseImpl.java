package br.com.lidiagaldino.feed.application.usecases.impl;

import br.com.lidiagaldino.feed.application.usecases.FindAllPostsUsecase;
import br.com.lidiagaldino.feed.domain.entities.TranslatedPost;
import br.com.lidiagaldino.feed.domain.repositories.PostRepository;
import br.com.lidiagaldino.feed.domain.services.TranslationService;
import io.smallrye.mutiny.Multi;
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
    public Multi<TranslatedPost> execute() {
        return postRepository.findAll()
                .flatMap(i -> translationService.translate(i.getContent(), "en", "pt")
                        .onItem().transform(translatedContent -> new TranslatedPost(i, translatedContent)).toMulti()
                );
    }
}
