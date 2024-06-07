package test;

import java.util.ArrayList;
import java.util.List;

import DAO.Article;
import DAO.Panier;
import DAO.User;
import Manager.ManageDAO;


public class test {

	public static void main(String[] args) {
		
		
		ManageDAO<User> mUser = new ManageDAO<User>(User.class);
		
		List<Article> lArticle = new ArrayList<Article>();
		
		Panier panier = new Panier();
		
		
		lArticle.add(new Article(100L, "Ma7ya1", 10L));
		lArticle.add(new Article(100L, "Ma7ya2", 10L));
		lArticle.add(new Article(100L, "Ma7ya3", 10L));
		lArticle.add(new Article(100L, "Ma7ya4", 10L));
		
		
		panier.setlArticle(lArticle);
		
		
		User user= new User("xxxx");
		user.setArticle(panier);
		
		mUser.insertUser(user);
		
	}

}
