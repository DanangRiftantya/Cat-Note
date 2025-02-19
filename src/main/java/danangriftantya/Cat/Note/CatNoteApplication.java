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

	public static void main(String[] args) {

		SpringApplication.run(CatNoteApplication.class, args);

//		try {
//			Class.forName("org.postgresql.Driver");
//			Connection connection = DriverManager.getConnection(
//					"jdbc:postgresql://localhost:5432/postgres",
//					"postgres",
//					"Muhammad$201000"
//			);
//			System.out.println("✅ Connection successful!");
//			connection.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
