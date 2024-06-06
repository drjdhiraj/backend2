package com.dhiraj.service;

import java.util.List;

import com.dhiraj.exception.LikeException;
import com.dhiraj.exception.TwitException;
import com.dhiraj.exception.UserException;
import com.dhiraj.model.Like;
import com.dhiraj.model.User;

public interface LikesService {
	
	public Like likeTwit(Long twitId, User user) throws UserException, TwitException;
	
	public Like unlikeTwit(Long twitId, User user) throws UserException, TwitException, LikeException;
	
	public List<Like> getAllLikes(Long twitId) throws TwitException;

}
