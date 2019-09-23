package com.rd.familytree.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rd.familytree.domain.Member;

public interface MemberRepository extends CrudRepository<Member, Long>{

	List<Member> findByFirstName(String firstName);
	
	List<Member> findByLastName(String lastName);
	
	@Query("SELECT m FROM Member m WHERE m.firstName=:firstName and m.lastName=:lastName")
	List<Member> findByFirstAndLastName(@Param("firstName") String firstName, @Param("lastName") String LastName);
	
}
