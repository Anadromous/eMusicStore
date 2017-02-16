package com.emusicstore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery("from Product");
		List<Product> products= query.getResultList();
		session.flush();
		return products;
	}

	@Override
	public void deleteProduct(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(id));
		session.flush();
	}

	@Override
	public Product getProductById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		session.flush();
		return product;
	}

}
