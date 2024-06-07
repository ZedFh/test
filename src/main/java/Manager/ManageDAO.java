package Manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class ManageDAO<T> {

	
    private Class<T> entityClass;

    public ManageDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
	
	
	
	public void insertUser(T object) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("WebStore");
			em = emf.createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(object);;
			trans.commit();
		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) 
				em.getTransaction().rollback();
		} finally {
			if (em != null) 
				em.close();
			if (emf != null) 
				emf.close();
		}
	}
	
	public void updateUser(T object) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("WebStore");
			em = emf.createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.merge(object);
			trans.commit();
		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) 
				em.getTransaction().rollback();
		} finally {
			if (em != null) 
				em.close();
			if (emf != null) 
				emf.close();
		}
	}
	
	public void deleteUser(Integer id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("WebStore");
			em = emf.createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			T entity = em.find(entityClass, id);
			em.remove(entity);
			trans.commit();
		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) 
				em.getTransaction().rollback();
		} finally {
			if (em != null) 
				em.close();
			if (emf != null) 
				emf.close();
		}
	}
	
	

    public Object getObjectById(Integer id) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Object object = null;

        try {
            emf = Persistence.createEntityManagerFactory("WebStore");
            em = emf.createEntityManager();
            object = em.find(entityClass, id);
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }

        return object;
    }
	
    public List<?> getAllObjects() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        List<?> objects = null;

        try {
            emf = Persistence.createEntityManagerFactory("WebStore");
            em = emf.createEntityManager();
            String entityName = entityClass.getSimpleName();
            TypedQuery<?> query = em.createQuery("SELECT e FROM " + entityName + " e", entityClass);
            
            objects = query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }

        return objects;
    }


    
    
		
}