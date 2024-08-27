package ca.mohsinriaz.url_shortener_backend;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Link {
    @Id
    @JsonIgnore
    private String id;
    @NotBlank
    private String longUrl;
    @NotBlank
    private String shortUrl;

    public Link(String longUrl,
                String shortUrl
                ) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

//     -----Random string generation done on frontend------
//    private String generateShortUrl() {
//        RandomStringGenerator generator = new RandomStringGenerator.Builder()
//                .withinRange('0', '9')
//                .withinRange('a', 'z')
//                .build();
//        return generator.generate(8);
//    }


}
