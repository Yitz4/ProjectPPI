package com.project.Camp.repositories;

import com.project.Camp.controller.CamperModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CamperRepository extends CrudRepository<CamperModel, Long> {

    public Optional<CamperModel> findByName(String name);
    public Optional<CamperModel> findByPhone(Long phone);
    public Optional<CamperModel> findByEmail(String email);
}
