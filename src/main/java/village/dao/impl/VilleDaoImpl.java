package village.dao.impl;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import village.Application;
import village.dao.VilleDao;
import village.model.Ville;

public class VilleDaoImpl implements VilleDao{

		@Override
		public Ville find(Integer id) {
			Ville ville = null;
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				ville = em.find(Ville.class, id);

				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
			} finally {

				if (em != null) {
					em.close();
				}
			}
			return villes;
		}

		@Override
		public List<Ville> findAll() {
			List<Ville> liste = null;
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				Query query = em.createQuery("from Ville");
				liste = query.getResultList();

				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
			} finally {

				if (em != null) {
					em.close();
				}
			}
			return liste;
		}

		@Override
		public void create(Ville obj) {
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();
				
				em.persist(obj);

				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
			} finally {

				if (em != null) {
					em.close();
				}
			}
		}

		@Override
		public Ville update(Ville obj) {
			Ville objCopy = null;
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				objCopy = em.merge(obj);

				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
			} finally {

				if (em != null) {
					em.close();
				}
			}

			return objCopy;
		}

		@Override
		public void delete(Ville obj) {
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				em.remove(em.merge(obj));

				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
			} finally {

				if (em != null) {
					em.close();
				}
			}
		}

		@Override
		public List<Ville> findAllByNomOrDescription(String code, String libelle) {
			List<Ville> liste = null;
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<Ville> criteriaQuery = cb.createQuery(Ville.class);
				
				Root<Ville> categorie = criteriaQuery.from(Ville.class);
				criteriaQuery.select(categorie);
				
				if(!nom.isEmpty()) {
					criteriaQuery.where(cb.like(categorie.get("code"), code));
				} else if(!libelle.isEmpty()) {
					criteriaQuery.where(cb.like(categorie.get("libelle"), libelle));
				}
				
				TypedQuery<Ville> query = em.createQuery(criteriaQuery);
				liste = query.getResultList();
				

				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
			} finally {

				if (em != null) {
					em.close();
				}
			}
			return liste;
		}

	}


}
