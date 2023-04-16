package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!


    //add a method to sort by last name
    //JPA MAGIC: automaticlly creates query:
    //                      "from Employee order by lastName asc"

    //Spring Data JPA will parse the method name
    //Looks for a specific format and pattern
    //Creates appropriate query
    public List<Employee> findAllByOrderByLastNameAsc();
}
