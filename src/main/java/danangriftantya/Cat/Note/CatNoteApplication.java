package danangriftantya.Cat.Note;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "danangriftantya.Cat.Note")
@EntityScan(basePackages = "danangriftantya.Cat.Note")

public class CatNoteApplication {

	public static void main(String[] args) {SpringApplication.run(CatNoteApplication.class, args);}

}
