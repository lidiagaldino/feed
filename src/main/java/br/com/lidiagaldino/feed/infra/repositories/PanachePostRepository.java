package br.com.lidiagaldino.feed.infra.repositories;

import br.com.lidiagaldino.feed.domain.entities.Post;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanachePostRepository implements ReactivePanacheMongoRepository<Post> {
}
