package com.wroclaw.saline.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wroclaw.saline.enums.EnumStatesOfBoard;

@Entity
public class PositionInBoard {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private EnumStatesOfBoard enumStatesOfBoard = EnumStatesOfBoard.EMPTY;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
	private Board board;
	
	public PositionInBoard() {
	}
	
	public PositionInBoard(EnumStatesOfBoard parameter) {
		enumStatesOfBoard = parameter;
	} 

	public EnumStatesOfBoard getEnumStatesOfBoard() {
		return enumStatesOfBoard;
	}

	public void setEnumStatesOfBoard(EnumStatesOfBoard enumStatesOfBoard) {
		this.enumStatesOfBoard = enumStatesOfBoard;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	};

}
