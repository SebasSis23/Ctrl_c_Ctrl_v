package com.example.sprintbot.repository;

import com.example.sprintbot.entity.Orguser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrguserRepository extends JpaRepository<Orguser, String> {

}