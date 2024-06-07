package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Panier {
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	List<Article> lArticle;
	
	public Panier() {
		lArticle= new ArrayList<Article>(); 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Article> getlArticle() {
		return lArticle;
	}

	public void setlArticle(List<Article> lArticle) {
		this.lArticle = lArticle;
	}

	public Panier(List<Article> lArticle) {
		super();
		this.lArticle = lArticle;
	}

	
	
	
	
}
