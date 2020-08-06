package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

// Ad is the reference type of the entity to CRUD
// Long is the reference type for Primary Key of Ad
public interface AdRepository extends JpaRepository<Ad, Long> {

}
