package ca.mohsinriaz.url_shortener_backend;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LinkRepository extends MongoRepository<Link, String> {

//    List<Link> findAll();

    Optional<Link> findLinkByshortUrl(String shortUrl);

//    Link createLink(Link link);

    void deleteLinkByshortUrl(String ShortUrl);


}

