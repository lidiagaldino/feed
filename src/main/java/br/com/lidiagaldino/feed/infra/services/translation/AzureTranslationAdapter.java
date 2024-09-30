package br.com.lidiagaldino.feed.infra.services.translation;

import jakarta.annotation.PostConstruct;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.azure.ai.translation.text.TextTranslationClient;
import com.azure.ai.translation.text.TextTranslationClientBuilder;
import com.azure.core.credential.AzureKeyCredential;

import br.com.lidiagaldino.feed.domain.services.TranslationService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AzureTranslationAdapter implements TranslationService {

  @ConfigProperty(name = "azure.translator.api-key")
  private String apiKey;
  @ConfigProperty(name = "azure.translator.region")
  private String region;

  private TextTranslationClient client;

  @PostConstruct
  public void init() {
    AzureKeyCredential credential = new AzureKeyCredential(apiKey);
    this.client = new TextTranslationClientBuilder()
            .credential(credential)
            .region(region)
            .endpoint("https://api.cognitive.microsofttranslator.com")
            .buildClient();
  }

  @Override
  public Uni<String> translate(String content, String targetLang) {
    return Uni.createFrom().item(() -> {
      var translationResult = client.translate(
          targetLang,
          content
      );
      return translationResult.getTranslations().get(0).getText();
  }).onItem().transform(text -> text);
  }
}
