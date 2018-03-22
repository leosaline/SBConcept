package com.wroclaw.saline;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wroclaw.saline.entity.PositionInBoard;
import com.wroclaw.saline.enums.EnumStatesOfBoard;
import com.wroclaw.saline.repository.PositionInBoardRepository;

@SpringBootApplication
public class SbConceptApplication {

	@Autowired
	private PositionInBoardRepository positionRepository;

	public static void main(String[] args) {
		SpringApplication.run(SbConceptApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
//			positionRepository.save(new PositionInBoard(EnumStatesOfBoard.BALL));
//			positionRepository.save(new PositionInBoard(EnumStatesOfBoard.EMPTY));
//			positionRepository.save(new PositionInBoard(EnumStatesOfBoard.ROUND));
		};
	}
}
