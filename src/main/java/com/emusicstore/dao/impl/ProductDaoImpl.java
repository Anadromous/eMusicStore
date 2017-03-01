package com.emusicstore.dao.impl;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import com.mysql.jdbc.log.LogFactory;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pchapman on 1/6/2016.
 */

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	final static Logger log = Logger.getLogger(ProductDaoImpl.class);
	
    @Autowired
    private SessionFactory sessionFactory;

    public Product getProductById (int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();

        return product;
    }

    public List<Product> getProductList() {
    	log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> getProductList");
        Session session = sessionFactory.getCurrentSession();
        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> getProductList session: "+session.toString());
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();
        session.flush();

        return productList;
    }

    public void addProduct (Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct (Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct (Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }
}
