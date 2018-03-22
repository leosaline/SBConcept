package com.wroclaw.saline.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy="board")
	private Set<PositionInBoard> boardPositions;
	
	public Board() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<PositionInBoard> getBoardPositions() {
		return boardPositions;
	}

	public void setBoardPositions(Set<PositionInBoard> boardPositions) {
		this.boardPositions = boardPositions;
	}
}
