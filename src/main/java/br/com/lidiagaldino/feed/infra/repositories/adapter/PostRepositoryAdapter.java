package br.com.lidiagaldino.feed.infra.repositories.adapter;

import br.com.lidiagaldino.feed.domain.entities.Post;
import br.com.lidiagaldino.feed.domain.repositories.PostRepository;
import br.com.lidiagaldino.feed.infra.repositories.PanachePostRepository;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;

@ApplicationScoped
public class PostRepositoryAdapter implements PostRepository {

    @Inject
    private final PanachePostRepository panachePostRepository;

    public PostRepositoryAdapter(PanachePostRepository panachePostRepository) {
        this.panachePostRepository = panachePostRepository;
    }

    @Override
    public Uni<Post> create(Post post) {
        return panachePostRepository.persist(post);
    }

    @Override
    public Uni<Post> findById(ObjectId id) {
        return null;
    }

    @Override
    public Multi<Post> findByAuthor(String author) {
        return panachePostRepository.find("author", author).stream();
    }

    @Override
    public Multi<Post> findAll() {
        return panachePostRepository.findAll().stream();
    }
}
