package productapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.LockMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productapp.entity.Product;

@Component
public class ProductDao {
		@Autowired
	private HibernateTemplate hibernateTemplate;
		//create
		@Transactional
		public void createProduct(Product product) {
			hibernateTemplate.saveOrUpdate(product);
		}
		
		//getallproducts
		public List<Product> gettAllProducts() {
			return hibernateTemplate.loadAll(Product.class);
			
		}	
		//delete single product
		@Transactional
		public void deleteProduct(int pid) {
			Product p=hibernateTemplate.get(Product.class, pid);
			hibernateTemplate.delete(p);
		}
		//getsingleproduct
		public Product getProductById(int pid) {
			Product p= hibernateTemplate.get(Product.class, pid);
			return p;
		}
		//updateProduct
		@Transactional
		public void updateProduct(Product product) {	

		if(product!=null) {
			this.hibernateTemplate.update(product);
	}else {
			throw new RuntimeException("given" +product.getName()+"doesnot exist");
	}
		}
}
