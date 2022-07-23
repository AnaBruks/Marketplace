package org.marketplace.springwebapp.Marketplace.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.marketplace.springwebapp.Marketplace.models.Product;
import org.marketplace.springwebapp.Marketplace.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UsersDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UsersDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional (readOnly = true)
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User", User.class)
                .getResultList();
    }
    @Transactional
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
    @Transactional (readOnly = true)
    public User showUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
    @Transactional
    public void update(int id, User user) {
        Session session = sessionFactory.getCurrentSession();
        User oldUser = session.get(User.class, id);
        oldUser.setName(user.getName());
        oldUser.setSurname(user.getName());
        oldUser.setMoney(user.getMoney());
    }
    @Transactional
    public void destroy(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(User.class, id));
    }

    public void buy(int userId, int productId) {
        User user = showUser(userId);
        double account = user.getMoney();
        Product product = showProduct(productId);

        if (account < product.getPrice()){
            throw new UnsupportedOperationException("The price is too high, earn more money!");
        }else{
            user.getPurchases().add(product);
            user.setMoney(account - product.getPrice());
        }
    }

    @Transactional (readOnly = true)
    public Product showProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }
}
