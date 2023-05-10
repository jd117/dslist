package com.devsuperiorpt.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperiorpt.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
