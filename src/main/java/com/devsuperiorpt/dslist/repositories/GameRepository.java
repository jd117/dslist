package com.devsuperiorpt.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperiorpt.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
