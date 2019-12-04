package com.revature.daos;

import java.util.List;

import com.revature.models.UserProfile;

public interface UserProfileDao {

	public List<UserProfile> getOne(int id);
	public void updateProfile(String address, int phonenumber, int id);
}
