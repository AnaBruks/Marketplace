package org.marketplace.springwebapp.dao;

import org.marketplace.springwebapp.models.Product;
import org.marketplace.springwebapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.marketplace.springwebapp.controllers.ProductController.showProduct;

@Component
public class UsersDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> index() {
        return jdbcTemplate.query("SELECT * FROM Users", new BeanPropertyRowMapper<>(User.class));
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO Users (name, surname, money) VALUES (?,?,?)",
                user.getName(), user.getSurname(), user.getMoney());
    }

    public User showUser(int id) {
        return (User)jdbcTemplate.query("SELECT * FROM Users where id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(User.class));
    }
    public void update(int id, User user) {
        jdbcTemplate.update("UPDATE Users SET name=? , surname =?, money =? purchases =? WHERE id = ?",
                user.getName(), user.getSurname(), user.getMoney(), user.getPurchases(), id);
    }

    public void destroy(int id) {
        jdbcTemplate.update("DELETE FROM Users WHERE id = ?", id);
    }

    /*
● If user doesn't have enough money to buy product, throw exception
● If user successfully bought the product display message about successful purchase
● When user is buying product, his amount of money decreases by product price
● After successful purchase, information about user and his products has to be stored in collection best
suited for that purpose
 */
    public String buy(int userId, int productId) {
        User user = showUser(userId);
        Product product = showProduct(productId);

        if (user.getMoney() < product.getPrice()){
            throw new UnsupportedOperationException("The price is too high, earn more money!");
        }else{
            user.getMoney() -= product.getPrice();
            user.getPurchases().add(product);
        }
        return "";
    }

}
