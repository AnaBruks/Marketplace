package org.marketplace.springwebapp.Marketplace.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.marketplace.springwebapp.Marketplace.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class ProductsDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductsDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Product> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Product", Product.class)
                .getResultList();
    }
    @Transactional
    public void save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }
    @Transactional (readOnly = true)
    public Product showProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Transactional
    public void update(int id, Product product) {
        Session session = sessionFactory.getCurrentSession();
        Product oldProduct = session.get(Product.class, id);
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
    }
    @Transactional
    public void destroy(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Product.class, id));
    }
}
