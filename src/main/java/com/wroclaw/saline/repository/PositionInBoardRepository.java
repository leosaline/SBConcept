package com.wroclaw.saline.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wroclaw.saline.entity.PositionInBoard;

@Repository
public interface PositionInBoardRepository extends CrudRepository<PositionInBoard, Integer>{
	
	@Query(value="Select p from PositionInBoard p where p.enumStatesOfBoard = com.wroclaw.saline.enums.EnumStatesOfBoard.EMPTY ")
	public PositionInBoard findPositionInitialEmpty();

}
