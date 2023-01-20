package com.example.application.dao;

import com.example.application.Entity.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, Integer> {

}
