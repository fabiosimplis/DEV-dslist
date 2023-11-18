package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)//Do Spring, pois aqui não vai fazer operacão de escrita, não bloqueando o BD para escrita
    public GameDTO findById(Long id){
        Game game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){

        List<Game> listaDeGames = gameRepository.findAll();

        return listaDeGames.stream().map(game -> new GameMinDTO(game)).toList();
    }
}
