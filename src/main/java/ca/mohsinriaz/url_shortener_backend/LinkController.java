package ca.mohsinriaz.url_shortener_backend;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.MalformedURLException;
import java.util.List;

@Valid
@RestController
@RequestMapping("")
@AllArgsConstructor
public class LinkController {

    private final LinkService linkService;


    @GetMapping("/get")
    public List<Link> fetchLinks() {
        return linkService.findAll();
    }

    @GetMapping("/v/{id}")
    public RedirectView fetchLinksById(@PathVariable String id) throws MalformedURLException {
        String link = linkService.findLink(id);
        if(link.isEmpty()){
            throw new LinkNotFoundException();
        }
        return new RedirectView(link);
    }

    @PostMapping("/post")
    public Link postLink(@Valid @RequestBody Link link){
        return linkService.createLink(link);
    }

    @DeleteMapping("/v/{id}")
    void deleteLink(@PathVariable String id){
        linkService.deleteLink(id);
    }



}
