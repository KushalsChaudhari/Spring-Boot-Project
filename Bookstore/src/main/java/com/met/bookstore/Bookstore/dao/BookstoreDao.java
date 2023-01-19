package com.met.bookstore.Bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.met.bookstore.Bookstore.model.Bookstore;

@Repository
public class BookstoreDao {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(Bookstore bs) {
		
		
		saveUsingJDBCTemplate(bs);
		
		
		System.out.println("Saving emp to database: " + bs);
		
	}
	
	private void saveUsingJDBCTemplate(Bookstore bs) {
		
		jdbcTemplate.update("insert into Employeetbl values(?, ?, ?, ?)", 
					new Object[] {bs.getBookId(), bs.getBookName(), bs.getAuthor(),
							bs.getPublisher()}
				);
		
	}
	public Bookstore getBook(int id) {
		
		return jdbcTemplate.queryForObject("select * from employeetbl where id=?", 
				new Object[] {id}, new BeanPropertyRowMapper<>(Bookstore.class));
		
	}
	
    public  Collection<Bookstore> getAllBooks(){
		
		
		return jdbcTemplate.query("select * from Bookstore", 
				
					new BeanPropertyRowMapper<Bookstore>(Bookstore.class)
					//new EmployeeMapper()
				
				);
		
		
	}

	
	
//	class BookstoreMapper implements RowMapper<Bookstore>{
//
//		public Bookstore mapRow(ResultSet rs, int arg1) throws SQLException {
//			// TODO Auto-generated method stub
//			
//			Bookstore bookstore = new Bookstore();
//			bookstore.setBookId(rs.getInt("BookId"));
//			bookstore.setBookName(rs.getString("Bookname"));
//			bookstore.setAuthor(rs.getString("Author"));
//			bookstore.setPublisher(rs.getString("Publisher"));
//			
//			return bookstore;
//		}
//	}


}
