package productapp.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productapp.dao.ProductDao;
import productapp.entity.Product;

@Controller
public class MainController {
	@Autowired
private ProductDao productDao;
	@RequestMapping("/")
	public String home(Model model) {
		List<Product> products=productDao.gettAllProducts();
		model.addAttribute("products",products);
		return "index";
	}

//show add product form 
	@RequestMapping("/addproduct")
	public String addProduct(Model model){
		model.addAttribute("title","add product");
		return "add_product";
	}
	
	//handling the product details
	@RequestMapping(value="/handlerproduct",method = RequestMethod.POST  )
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest req) {
	this.productDao.createProduct(product);
		RedirectView redirectView=new RedirectView();
	redirectView.setUrl(req.getContextPath()+"/");
	return redirectView;
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
	public RedirectView deleteProduct(@PathVariable("id") int id,HttpServletRequest req) {
		this.productDao.deleteProduct(id);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/");
		return redirectView;
		}
	@RequestMapping(value="/update/{id}")
		public String updateForm(Model m,@PathVariable("id") int id) {
		Product product=this.productDao.getProductById(id);
		m.addAttribute("product",product);
		return "update_form";
	}	
	
	@RequestMapping(value="/updateproduct",method = RequestMethod.POST)
	public RedirectView updateProduct(@ModelAttribute Product product,HttpServletRequest req) {
		
		this.productDao.updateProduct(product);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/");
		return redirectView;
	}
//	
//	
	
}