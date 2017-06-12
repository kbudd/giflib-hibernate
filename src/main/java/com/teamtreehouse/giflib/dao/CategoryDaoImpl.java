package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by kylebudd on 5/23/17.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        /** Open a session */
        Session session = sessionFactory.openSession();

        /** Get all categories with a Hibernate criteria */
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> criteria = builder.createQuery(Category.class);
        criteria.from(Category.class);
        List<Category> categories = session.createQuery(criteria).getResultList();

        /** Close the session */
        session.close();

        return categories;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void save(Category category) {

        /** Open a session */
        Session session = sessionFactory.openSession();

        /** Begin a transaction */
        session.beginTransaction();

        /** Save the category */
        session.save(category);

        /** Commit the transaction */
        session.getTransaction().commit();

        /** Close the session */
        session.close();

    }

    @Override
    public void delete(Category category) {

    }
}
