package com.wroclaw.saline.repository;

import org.springframework.data.repository.CrudRepository;

import com.wroclaw.saline.entity.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {

}
