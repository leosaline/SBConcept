package com.wroclaw.saline.engine;

import com.wroclaw.saline.entity.Game;
import com.wroclaw.saline.enums.EnumStatesOfBoard;

public class EngineGame {

	public Game executeMovement(Game game, Game gameSaved) {
		int winner = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				winner = game.getBoard().getBoardPositions()[i][j].getEnumStatesOfBoard().compareTo(
						game.getBoard().getBoardPositions()[i][j + 1].getEnumStatesOfBoard());
				if(game.getBoard().getBoardPositions()[i][j].getEnumStatesOfBoard().equals(EnumStatesOfBoard.EMPTY)) {
					winner = 1;
				}
			}
			
			for (int j = 0; j < 3; j++) {
				winner = game.getBoard().getBoardPositions()[j][i].getEnumStatesOfBoard().compareTo(
						game.getBoard().getBoardPositions()[j + 1][i].getEnumStatesOfBoard());
				
			}			
			
			if(winner == 0) {
				throw new IllegalArgumentException("congratullations, you are the winner!");
			}
		}
		
		
		return game;
	}
}