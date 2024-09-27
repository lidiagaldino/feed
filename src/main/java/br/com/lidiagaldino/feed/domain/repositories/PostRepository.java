package br.com.lidiagaldino.feed.domain.repositories;

import br.com.lidiagaldino.feed.domain.entities.Post;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;

public interface PostRepository {
    Uni<Post> create(Post post);
    Uni<Post> findById(ObjectId id);
    Multi<Post> findByAuthor(String author);
    Multi<Post> findAll();
}
