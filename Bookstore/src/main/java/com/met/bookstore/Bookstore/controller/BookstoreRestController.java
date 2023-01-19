package com.met.bookstore.Bookstore.controller;

import java.awt.PageAttributes.MediaType;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.met.bookstore.Bookstore.model.Bookstore;
import com.met.bookstore.Bookstore.service.BookstoreService;

@RestController
@RequestMapping("/books")
public class BookstoreRestController {

	@Autowired
	private BookstoreService bookstoreservice;
	
	
	@RequestMapping(value = "allbooks")
	public ResponseEntity<Collection<Bookstore>> getAllEmps(){
		
		Collection<Bookstore> allBooks =bookstoreservice.getAllBooks();
		
		return new ResponseEntity<Collection<Bookstore>>(allBooks, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "getBook/{id}")
	public ResponseEntity<Bookstore> getEmp(@PathVariable int id){
		
		Bookstore bookstore = bookstoreservice.getBook(id);
		
		return new ResponseEntity<Bookstore>(bookstore, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "updateEmp")
	public ResponseEntity<Bookstore> updateEmp(@RequestBody Bookstore bookstore){
		
		return null;
	}
	
	@DeleteMapping(value = "deleteEmp/{id}")
	public ResponseEntity<Bookstore> deleteEmp(@PathVariable int id){
		
		
		return null;
		
	}
	
	
	@PostMapping
	@RequestMapping(value = "savebook")
	public ResponseEntity<Bookstore> saveEmp(@RequestBody Bookstore bookstore){
		
		bookstoreservice.save(bookstore);
		
		return new ResponseEntity<Bookstore>(bookstore, HttpStatus.OK);
		
		
	}
	
}
