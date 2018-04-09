package com.wroclaw.saline.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.wroclaw.saline.entity.Board;
import com.wroclaw.saline.entity.Game;
import com.wroclaw.saline.entity.PositionInBoard;
import com.wroclaw.saline.enums.EnumStatesOfBoard;
import com.wroclaw.saline.repository.GameRepository;

@SpringBootTest
public class GameServiceTests {
	GameService gameService;
	GameService gameServiceMock;
	GameRepository gameRepository;
	
	@Before
	public void setUp() {
		Game gameSaved = new Game();
		gameSaved.setBoard(new Board());
		gameSaved.getBoard().setBoardPositions(new HashSet<>());
		PositionInBoard position = new PositionInBoard(EnumStatesOfBoard.EMPTY);
		position.setId(new Integer(1));
		gameSaved.getBoard().getBoardPositions().add(position);
		
		Optional<Game> optGame = Optional.of(gameSaved);
		
		gameRepository = Mockito.mock(GameRepository.class);
		when(gameRepository.findById(new Integer(1))).thenReturn(optGame);
		gameService = new GameService(gameRepository);
		gameServiceMock = new GameService(gameRepository);
	}

	@Test(expected=IllegalArgumentException.class)
	public void whenSendMovToFinishedGameReceiveErro(){
		Game game = new Game();
		game.setFinished(true);
		gameServiceMock.move(game);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void whenSelectOccupiedPositionReceiveErro() {
		Game game = new Game();
		game.setFinished(false);
		game.setBoard(new Board());
		game.getBoard().setBoardPositions(new HashSet<>());
		gameServiceMock.move(game);
	}
	
	@Test
	public void whenSelectEmptyPositionThenMark() {
		Game game = new Game();
		game.setId(new Integer(1));
		game.setFinished(false);
		game.setBoard(new Board());
		game.getBoard().setBoardPositions(new HashSet<>());
		PositionInBoard position = new PositionInBoard(EnumStatesOfBoard.BALL);
		game.getBoard().getBoardPositions().add(position);
		System.out.println("1 +++++++++++++++++++++++");
		Game gameMoved = gameService.move(game);
		System.out.println("2 +++++++++++++++++++++++");
		
		assertEquals(EnumStatesOfBoard.BALL, gameMoved.getBoard().getBoardPositions().iterator().next().getEnumStatesOfBoard());
	}
}
