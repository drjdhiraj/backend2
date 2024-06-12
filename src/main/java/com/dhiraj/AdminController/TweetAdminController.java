package com.dhiraj.AdminController;


import com.dhiraj.dto.TwitDto;
import com.dhiraj.dto.mapper.TwitDtoMapper;
import com.dhiraj.exception.UserException;
import com.dhiraj.model.Twit;
import com.dhiraj.model.User;
import com.dhiraj.repository.TwitRepository;
import com.dhiraj.repository.UserRepository;
import com.dhiraj.service.TwitService;
import com.dhiraj.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TweetAdminController {

    private final UserRepository userRepository;
    TwitRepository twitRepository;
    private final TwitService twitService;

    UserService userService;




    public TweetAdminController(TwitService twitService, TwitRepository twitRepository, UserService userService, UserRepository userRepository) {
        this.twitService = twitService;
        this.twitRepository = twitRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public List<Twit> call(){
        return twitService.findAllTwit();
    }

    @GetMapping("/getalltwitsall")
    public ResponseEntity<List<TwitDto>> findAllTwits() throws UserException {
        User user= userRepository.getFirstByEmailContainingIgnoreCase("@");
        List<Twit> twits=twitService.findAllTwit();
        List<TwitDto> twitDtos= TwitDtoMapper.toTwitDtos(twits,user);
        return new ResponseEntity<>(twitDtos, HttpStatus.OK);
    }


}
