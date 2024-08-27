package ca.mohsinriaz.url_shortener_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(LinkRepository linkRepository, MongoTemplate mongoTemplate){
		return args -> {
			Link link = new Link(
					"http://google.ca",
					"firstlink"
			);

			Link link2 = new Link(
					"http://bing.com",
					"secondlink"
			);

			//usingMongoTemplateAndQuery(linkRepository, mongoTemplate, link);

			linkRepository
					.findLinkByshortUrl("firstlink")
					.ifPresentOrElse(l -> {
						System.out.println(l + " already exists");
					},() -> {
						System.out.println("Inserting link " + link);
						linkRepository.insert(link);
					});
		};
	}

	private static void usingMongoTemplateAndQuery(LinkRepository linkRepository, MongoTemplate mongoTemplate, Link link) {
		Query query = new Query();
		query.addCriteria(Criteria.where("shortUrl").is("http://localhost:8080/asdasdasd"));


		List<Link> links = mongoTemplate.find(query, Link.class);

		if (links.size() > 1){
			throw new IllegalStateException("Too many links found" + links);
		}else {
			System.out.println("links = " + links);
		}

		if (links.isEmpty()){
			System.out.println("Inserting link " + link);
			linkRepository.insert(link);
		} else {
			System.out.println(link + " already exists");
		}
	}
}
