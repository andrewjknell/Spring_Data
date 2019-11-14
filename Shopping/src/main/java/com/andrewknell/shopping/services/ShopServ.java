package com.andrewknell.shopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andrewknell.shopping.models.Category;
import com.andrewknell.shopping.models.Product;
import com.andrewknell.shopping.repositories.CategoryRepo;
import com.andrewknell.shopping.repositories.ProductRepo;

@Service
public class ShopServ {
	private final ProductRepo pR;
	private final CategoryRepo cR;
	
	public ShopServ(ProductRepo pR, CategoryRepo cR) {
		this.pR = pR;
		this.cR = cR;
	}
	
	public List<Category> getAll() {
        return cR.findAll();
    }
	
    public Category update(Category s) {
        return cR.save(s);
	}

	public void delete(Long x) {
		cR.deleteById(x);
		return;
	}
	
    public Category create(Category s) {
    	
        return cR.save(s);
    }

    public Category findOne(Long id) {
        Optional<Category> opt = cR.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }
    
	public List<Product> getAllP() {
        return pR.findAll();
    }
	
    public Product update(Product s) {
        return pR.save(s);
	}

	public void deleteP(Long x) {
		pR.deleteById(x);
		return;
	}
	
    public Product create(Product s) {
        return pR.save(s);
    }

    public Product findOneP(Long id) {
        Optional<Product> opt = pR.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }
}
