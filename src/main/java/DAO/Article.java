package DAO;





import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Article {
	@Override
	public String toString() {
		return "Article [id=" + id + ", price=" + price + ", name=" + name + ", masse=" + masse + "]";
	}


	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private Long price;
	
	@Column
	private String name;
	
	@Column
	private Long masse;
	
	
	
	
	public Article() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getMasse() {
		return masse;
	}


	public void setMasse(Long masse) {
		this.masse = masse;
	}


	public Article(Long price, String name, Long masse) {
		super();
		this.price = price;
		this.name = name;
		this.masse = masse;
	}
	

}
