package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 100)
	private String mdp;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	private List<Panier> lPanier =new ArrayList<Panier>();


	public User(String mdp) {
		super();
		this.mdp = mdp;
	}

	public User(Integer id, String mdp) {
		super();
		this.id = id;
		this.mdp = mdp;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Panier> getlArticle() {
		return lPanier;
	}

	public void setlArticle(List<Panier> lPanier) {
		this.lPanier = lPanier;
	}
	public void addArticle(Panier panier) {
		lPanier.add(panier);
		
	}
	
	public void removeArticle(Panier panier){
		lPanier.remove(panier);
	}
	
	public Panier getArticle(int index) {
		return lPanier.get(index);
	}
	
	public void listArticles() {
		for(Panier panier: lPanier)
			System.out.println(panier);
	}
	
	
	
	
	
	public User() {
		
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", mdp=" + mdp + "]";
	}

	public void setArticle(Panier panier) {
		lPanier.add(panier);
		
	}


}
