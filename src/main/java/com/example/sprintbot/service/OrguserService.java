package com.example.sprintbot.service;

import com.example.sprintbot.entity.Orguser;

import java.util.List;
import java.util.Optional;

public interface OrguserService {

    List<Orguser> findAll();

    Optional<Orguser> findById(String id);

    Orguser create(Orguser orguser);

    Optional<Orguser> update(String id, Orguser orguser);

    boolean deleteById(String id);
}
