package pl.dawidhonorowicz.library.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="isbn", nullable=false, unique=true)
	private String isbn;
	
	@Column(nullable = false)
	private String title;
	
	@Column(name = "release_date", nullable=false)
	private LocalDate releaseDate;
	
	@ManyToOne
	@JoinColumn(name="publisher_id", nullable=false)
	private Publisher publisher;
	
	@ManyToMany
	@JoinTable(name="book_has_author", 
			joinColumns={@JoinColumn(name="book_id",referencedColumnName="id" )},
			inverseJoinColumns= {@JoinColumn(name="author_id", referencedColumnName="id")})
	private List<Author> authors;

	@ManyToMany
	@JoinTable(name="book_has_category", 
			joinColumns={@JoinColumn(name="book_id", referencedColumnName="id")},
			inverseJoinColumns= {@JoinColumn(name="category_id", referencedColumnName="id")})
	private List<Category> categories;
}
