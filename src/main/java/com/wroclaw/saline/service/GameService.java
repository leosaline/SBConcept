package com.wroclaw.saline.service;

import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wroclaw.saline.engine.EngineGame;
import com.wroclaw.saline.entity.Board;
import com.wroclaw.saline.entity.Game;
import com.wroclaw.saline.entity.PositionInBoard;
import com.wroclaw.saline.entity.User;
import com.wroclaw.saline.enums.EnumStatesOfBoard;
import com.wroclaw.saline.repository.BoardRepository;
import com.wroclaw.saline.repository.GameRepository;
import com.wroclaw.saline.repository.PositionInBoardRepository;
import com.wroclaw.saline.repository.UserRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private PositionInBoardRepository positionRepository;
	
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
		
		Board board = new Board();
		board.setBoardPositions(new HashSet<>());
		
		for (int i = 0; i < 9; i++) {
			PositionInBoard position = positionRepository.save(new PositionInBoard(EnumStatesOfBoard.EMPTY));
			board.getBoardPositions().add(position);
		}
		
		board = boardRepository.save(board);
		game.setBoard(board);
		game.setUser(user);
		game.setDateCreated(new Date());
		game = gameRepository.save(game);
		
		return game;
	}

	public Game move(Game game) {
		validateMovement(game);
		
		EngineGame engineGame = new EngineGame();
		game = engineGame.executeMovement(game, gameRepository.findOne(game.getId()));
		
		
		return game;
	}

	private void validateMovement(Game game) {
		
		if(game.isFinished()) {
			throw new IllegalArgumentException("game already finished, create new game");
		} else {
			Game gameSaved = gameRepository.findOne(game.getId());
			gameSaved.getBoard().getBoardPositions();
//			int quantityMov = 0;
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
//					if(game.getBoard().getBoardPositions()[i][j] != gameSaved.getBoard().getBoardPositions()[i][j]) {
//						quantityMov++;
//						if(quantityMov == 2) {
//							throw new IllegalArgumentException("Only one movement per time allowed");
//						}
//						
//						if(gameSaved.getBoard().getBoardPositions()[i][j].equals(EnumStatesOfBoard.BALL)
//								|| gameSaved.getBoard().getBoardPositions()[i][j].equals(EnumStatesOfBoard.ROUND)) {
//							throw new IllegalArgumentException("Place in board already selected, please select another move");
//						}
//					}
				}
			}
			
		}
		
	}
}
