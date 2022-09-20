package com.accountOpening.repository;

import com.accountOpening.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login,Long> {
}
