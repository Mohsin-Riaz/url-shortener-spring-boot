package ca.mohsinriaz.url_shortener_backend;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException(){
        super("Link Not Found");
    }
}
