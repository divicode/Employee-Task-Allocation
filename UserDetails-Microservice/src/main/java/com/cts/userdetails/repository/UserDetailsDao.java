package com.cts.userdetails.repository;

import com.cts.userdetails.model.Login;
import com.cts.userdetails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsDao extends JpaRepository<User,Long> {

}
