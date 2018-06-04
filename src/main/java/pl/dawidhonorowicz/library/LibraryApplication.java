package pl.dawidhonorowicz.library;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.dawidhonorowicz.library.dao.BookDao;
import pl.dawidhonorowicz.library.model.Book;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(LibraryApplication.class, args);
		
	}
}
