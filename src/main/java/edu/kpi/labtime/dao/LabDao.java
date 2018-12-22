package edu.kpi.labtime.dao;

import edu.kpi.labtime.dto.Lab;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class LabDao {

    private final SessionFactory sessionFactory;

    public LabDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Lab findById(Integer id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Lab lab = entityManager.createQuery( "from Lab where id = ?", Lab.class)
                .setParameter(1,id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return lab;
    }

    public List<Lab> findBySubjectId(Integer subjectId) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Lab> result = entityManager.createQuery( "from Lab where subject_id = ?", Lab.class)
                .setParameter(1,subjectId)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public List<Lab> getAllLabss() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Lab> result = entityManager.createQuery( "from Lab", Lab.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

}
