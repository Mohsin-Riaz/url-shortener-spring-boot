package ca.mohsinriaz.url_shortener_backend;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class LinkService {

    private final LinkRepository linkRepository;

    public List<Link> findAll() {
        return linkRepository.findAll();
    }

    public String findLink(String id) throws MalformedURLException {
        Optional<Link> linkByshortUrl = linkRepository.findLinkByshortUrl(id);
        return linkByshortUrl.get().getLongUrl();
    }

    public Link createLink(Link link) {
        return linkRepository.insert(link);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteLink(String shortUrl){
        linkRepository.deleteLinkByshortUrl(shortUrl);
    }


}
