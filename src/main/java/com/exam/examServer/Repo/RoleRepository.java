package com.exam.examServer.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examServer.Models.Role;


public interface RoleRepository extends JpaRepository<Role,Long> {

}
