package com.api.crud.repositories;

import com.api.crud.models.UserModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
}
