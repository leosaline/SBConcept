package com.wroclaw.saline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wroclaw.saline.entity.Game;
import com.wroclaw.saline.service.GameService;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;

	@RequestMapping("/newGame/{game}")
	public Game startGame(@RequestParam(value="game", defaultValue="") Game game) {
		return gameService.startGame(game);
	}
	
	@RequestMapping("/move/{game}")
	public Game move(@RequestParam(value="game", defaultValue="") Game game) {
		return gameService.move(game);
	}
	
}
