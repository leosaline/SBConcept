package com.wroclaw.saline.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wroclaw.saline.entity.Board;
import com.wroclaw.saline.entity.Game;
import com.wroclaw.saline.entity.User;
import com.wroclaw.saline.repository.BoardRepository;
import com.wroclaw.saline.repository.GameRepository;
import com.wroclaw.saline.repository.UserRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	public GameService() {
	}
	
	public GameService(GameRepository repository) {
		this.gameRepository = repository;
	}

	public Game startGame(Game game) {
		User user = userRepository.findUserByLogin(game.getUser().getLogin());
		
		if(user == null) {
			throw new IllegalArgumentException("dont find user");
		}
		
		Board board = boardRepository.save(new Board());
		game.setBoard(board);
		game.setUser(user);
		game.setDateCreated(new Date());
		game = gameRepository.save(game);
		
		return game;
	}

	public Game move(Game game) {
		return null;
	}
}
