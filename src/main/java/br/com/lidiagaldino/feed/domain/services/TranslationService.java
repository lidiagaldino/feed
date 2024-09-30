package br.com.lidiagaldino.feed.domain.services;

import io.smallrye.mutiny.Uni;

public interface TranslationService {
  Uni<String> translate(String content, String sourceLang, String targetLang);
}
