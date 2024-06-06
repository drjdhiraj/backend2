package com.dhiraj.util;

import com.dhiraj.model.Like;
import com.dhiraj.model.Twit;
import com.dhiraj.model.User;

public class TweetUtil {
	
	public final static boolean isLikedByReqUser(User reqUser, Twit twit) {
		
		for(Like like : twit.getLikes()) {
			if (like.getUser().getId().equals(reqUser.getId())) {
				return true;
			}
		}
		return false;
	}
	
	public final static boolean isRetwitedByReqUser(User reqUser, Twit twit) {
		
		for(User user : twit.getRetwitUser()) {
			if (user.getId().equals(reqUser.getId())) {
				return true;
			}
		}
		return false;
	}

}
