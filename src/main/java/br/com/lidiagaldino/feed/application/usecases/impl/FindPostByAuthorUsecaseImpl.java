package br.com.lidiagaldino.feed.application.usecases.impl;

import br.com.lidiagaldino.feed.application.usecases.FindPostByAuthorUsecase;
import br.com.lidiagaldino.feed.domain.entities.TranslatedPost;
import br.com.lidiagaldino.feed.domain.repositories.PostRepository;
import br.com.lidiagaldino.feed.domain.services.TranslationService;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FindPostByAuthorUsecaseImpl implements FindPostByAuthorUsecase {

    private final PostRepository postRepository;
    private final TranslationService translationService;

    public FindPostByAuthorUsecaseImpl(PostRepository postRepository, TranslationService translationService) {
        this.postRepository = postRepository;
        this.translationService = translationService;
    }

    @Override
    public Multi<TranslatedPost> execute(String author) {
        return postRepository.findByAuthor(author).onItem().transform(i -> {
          var translatedContent = translationService.translate(i.getContent(), "pt", "en");
          return new TranslatedPost(i, translatedContent.toString());
        });
    }
}
