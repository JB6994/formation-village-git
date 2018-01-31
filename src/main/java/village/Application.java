package village;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import village.dao.RegionDao;
import village.dao.impl.RegionDaoImpl;



public class Application {
	
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("");

	private final RegionDao produitDao = new RegionDaoImpl();

	public static Application getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityManagerFactory getEmf() {
		// TODO Auto-generated method stub
		return null;
	}

	public RegionDao getProduitDao() {
		return produitDao;
	}
	
	
}


