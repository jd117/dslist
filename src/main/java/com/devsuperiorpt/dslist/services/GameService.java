package com.devsuperiorpt.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperiorpt.dslist.dto.GameDTO;
import com.devsuperiorpt.dslist.dto.GameMinDTO;
import com.devsuperiorpt.dslist.entities.Game;
import com.devsuperiorpt.dslist.projections.GameMinProjection;
import com.devsuperiorpt.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findByID(Long id) {
		Game result = gameRepository.findById(id).get();
		//GameDTO dto = new GameDTO(result); this and then return dto; or
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
