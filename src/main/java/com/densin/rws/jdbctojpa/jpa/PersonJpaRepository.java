package com.densin.rws.jdbctojpa.jpa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//import com.densin.rws.jdbctojpa.PersonJdbcDao.PersonRowMapper;
import com.densin.rws.jdbctojpa.entity.Person;

//Repository
//transactional

@Repository
@Transactional
public class PersonJpaRepository {
// connect to database
	@PersistenceContext
	
	EntityManager entityManager;
	
	
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person= new Person();
			
			person.setId(rs.getInt("id"));	
			person.setName(rs.getString("name"));	
			person.setLocation(rs.getString("location"));	
			person.setBirthDate(rs.getTimestamp("birth_date"));	
			return person;
		}
		
	}
	
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	public Person findbyId(int id) {
		return entityManager.find(Person.class, id);
	}
	public void Deletebyid(int id) {
		Person person = findbyId(id);
		 entityManager.remove(person);
	}
	
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery= entityManager.createNamedQuery("find_all_persons",Person.class);
		return namedQuery.getResultList();
		
		
	
			
	//"select * from person",new PersonRowMapper()
		}
}
