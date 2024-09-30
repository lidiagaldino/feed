package br.com.lidiagaldino.feed.controller;

import br.com.lidiagaldino.feed.application.dto.CreatePostDto;
import br.com.lidiagaldino.feed.application.usecases.CreatePostUsecase;
import br.com.lidiagaldino.feed.application.usecases.FindAllPostsUsecase;
import br.com.lidiagaldino.feed.application.usecases.FindPostByAuthorUsecase;
import br.com.lidiagaldino.feed.controller.params.LanguageQueryParam;
import br.com.lidiagaldino.feed.domain.entities.Post;
import br.com.lidiagaldino.feed.domain.entities.TranslatedPost;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostController {

    @Inject
    private final CreatePostUsecase createPostUsecase;
    @Inject
    private final FindAllPostsUsecase findAllPostsUsecase;
    @Inject
    private final FindPostByAuthorUsecase findPostByAuthorUsecase;

    public PostController(CreatePostUsecase createPostUsecase, FindAllPostsUsecase findAllPostsUsecase, FindPostByAuthorUsecase findPostByAuthorUsecase) {
        this.createPostUsecase = createPostUsecase;
        this.findAllPostsUsecase = findAllPostsUsecase;
        this.findPostByAuthorUsecase = findPostByAuthorUsecase;
    }


    @GET
    public Multi<TranslatedPost> index(
            @Valid @BeanParam LanguageQueryParam languageQueryParam
            ) {
        return findAllPostsUsecase.execute(languageQueryParam.getTargetLang());
    }

    @GET
    @Path("author/{name}")
    public Multi<TranslatedPost> findByAuthor(@PathParam("name") String name, @BeanParam LanguageQueryParam languageQueryParam) {
        return findPostByAuthorUsecase.execute(name, languageQueryParam.getTargetLang());
    }

    @POST
    public Uni<Post> store(CreatePostDto post) {
        return createPostUsecase.execute(post);
    }

}
