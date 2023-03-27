package com.moviebooking.theatreservice.repositories;

import com.moviebooking.theatreservice.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByUsername(String username);
}
