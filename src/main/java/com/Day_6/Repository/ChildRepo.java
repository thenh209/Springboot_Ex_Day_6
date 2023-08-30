package com.Day_6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Day_6.Model.Child;

@Repository
public interface ChildRepo extends JpaRepository<Child, Integer>{

}
