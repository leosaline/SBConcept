package com.wroclaw.saline.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.wroclaw.saline.enums.EnumStatesOfBoard;

@Entity
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private PositionInBoard[][] boardPositions;
	
	public Board() {
		boardPositions = new PositionInBoard[3][3];
		Arrays.stream(boardPositions).map(v -> EnumStatesOfBoard.EMPTY);
	}
}
