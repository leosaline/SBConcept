package com.wroclaw.saline.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

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

		if (user == null) {
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
		game = engineGame.executeMovement(game, gameRepository.findById(game.getId()));

		return game;
	}

	private void validateMovement(Game game) {
		if (game.isFinished()) {
			throw new IllegalArgumentException("game already finished, create new game");
		} else {
			Optional<Game> gameSaved = gameRepository.findById(game.getId());
			
			for (PositionInBoard positionSendUser : game.getBoard().getBoardPositions()) {
				if (positionSendUser.getEnumStatesOfBoard().equals(EnumStatesOfBoard.EMPTY)) {
					continue;
				}
				System.out.println("antes....");
				System.out.println("3 +++++++++++++++++++++++" + gameSaved.get().getBoard().getBoardPositions().stream()
						.filter(p -> p.getId() == positionSendUser.getId()).findFirst());
				
				
				PositionInBoard savedPos = (PositionInBoard) gameSaved.get().getBoard().getBoardPositions().stream()
						.filter(p -> p.getId() == positionSendUser.getId());
				System.out.println("salvo " + savedPos);
				if (savedPos.getEnumStatesOfBoard().compareTo(EnumStatesOfBoard.EMPTY) != 0) {
					if (positionSendUser.getEnumStatesOfBoard().compareTo(savedPos.getEnumStatesOfBoard()) != 0) {
						throw new IllegalArgumentException("you selected a non empty position");
					}
				}
			}
		}
	}
}
