package org.marketplace.springwebapp.dao;

import org.marketplace.springwebapp.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductsDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> index() {
        return jdbcTemplate.query("SELECT * FROM Products", new BeanPropertyRowMapper<>(Product.class));
    }

    public void save(Product product) {
        jdbcTemplate.update("INSERT INTO Products (name, price) VALUES (?,?)", product.getName(), product.getPrice());
    }

    public Product showProduct(int id) {
        return (Product) jdbcTemplate.query("SELECT * FROM Products where id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Product.class));
    }

    public void update(int id, Product product) {
        jdbcTemplate.update("UPDATE Products SET name=? , price =? WHERE id = ?",
                product.getName(), product.getPrice(), id);
    }

    public void destroy(int id) {
        jdbcTemplate.update("DELETE FROM Products WHERE id = ?", id);
    }
}
