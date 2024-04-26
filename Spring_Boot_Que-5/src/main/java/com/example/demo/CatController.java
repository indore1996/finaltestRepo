package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CatController {

	@Autowired
	private CategoryRepo proRepo;
	
	@GetMapping
	public Page<Category> getAll(@RequestParam int pageNo,@RequestParam int size){
		Pageable p = PageRequest.of(pageNo,size);
		
		return proRepo.findAll(p);
	}
	
	@GetMapping("/sort")
	public List<Category> getsort(@RequestParam String sortBy){
		Sort s = Sort.by(sortBy);
		
		return proRepo.findAll(s);
	}
	
	
	
	@PostMapping
	public Category createProduct(@RequestBody Category product) {
		return proRepo.save(product);
	}
	
	@GetMapping("/{id}")
	public Category createProductBId(@PathVariable Long id) throws Exception {
		return proRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
	}
	
	@PutMapping("/{id}")
	public Category createProduct(@RequestBody Category product,@PathVariable Long id) throws Exception {
		Category pro = proRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		
		pro.setName(product.getName());
		pro.setType(product.getType());
		pro.setProduct(product.getProduct());
		pro.setId(product.getId());
		
		return proRepo.save(pro);
	}
	
	@DeleteMapping("/{id}")
	public void delProduct(@PathVariable Long id) {
		proRepo.deleteById(id);
	}
}
