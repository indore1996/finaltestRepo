package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductRepo proRepo;
	
	@GetMapping
	public Page<Product> getAll(@RequestParam int pageNo,@RequestParam int size){
		Pageable p = PageRequest.of(pageNo,size);
		
		return proRepo.findAll(p);
	}
	
	@GetMapping("/sort")
	public List<Product> getsort(@RequestParam String sortBy){
		Sort s = Sort.by(sortBy);
		
		return proRepo.findAll(s);
	}
	
	
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return proRepo.save(product);
	}
	
	@GetMapping("/{id}")
	public Product createProductBId(@PathVariable Long id) throws Exception {
		return proRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
	}
	
	@PutMapping("/{id}")
	public Product createProduct(@RequestBody Product product,@PathVariable Long id) throws Exception {
		Product pro = proRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		
		pro.setPname(product.getPname());
		pro.setPtype(product.getPtype());
		pro.setId(product.getId());
		
		return proRepo.save(pro);
	}
	
	@DeleteMapping("/{id}")
	public void delProduct(@PathVariable Long id) {
		proRepo.deleteById(id);
	}
}
