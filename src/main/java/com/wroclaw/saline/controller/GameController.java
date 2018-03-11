package com.wroclaw.saline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wroclaw.saline.entity.Game;
import com.wroclaw.saline.entity.User;
import com.wroclaw.saline.service.GameService;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;

	@RequestMapping(value="/newgame/{login}", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Game> startGame(@PathVariable(value="login") String login) {
		Game game = new Game();
		game.setUser(new User());
		game.getUser().setLogin(login);
		
		try {
			return ResponseEntity.ok(gameService.startGame(game));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value="/move", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Game move(@RequestParam(value="game", defaultValue="") Game game) {
		return gameService.move(game);
	}
	
}
