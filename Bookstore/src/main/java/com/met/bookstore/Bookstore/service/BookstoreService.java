package com.met.bookstore.Bookstore.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.met.bookstore.Bookstore.dao.BookstoreDao;
import com.met.bookstore.Bookstore.model.Bookstore;

@Service
public class BookstoreService {
	
	@Autowired
	private BookstoreDao bookstoredao;
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void save(Bookstore bookstore) {
	
		//perform validations
		//if validated successfully call save method
		// if failed throw exception
		
		if(bookstore.getBookId() < 0) {
			throw new RuntimeException("EMployee ID cannot be < 1");
		}
		
		bookstoredao.save(bookstore);
		
		//updateEMployeeCOunt();
		
		System.out.println("Employee DAO class: " + bookstoredao.getClass());
		
	}

	public  Collection<Bookstore> getAllBooks(){
		
		return bookstoredao.getAllBooks();
		
	}
	
	//@Transactional -> if using hibernate 
	
	public Bookstore getBook(int id) {
		return bookstoredao.getBook(id);
	}

	
	
}
