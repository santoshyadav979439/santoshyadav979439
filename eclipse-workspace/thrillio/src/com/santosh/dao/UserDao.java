package com.santosh.dao;

import java.util.List;

import com.santosh.data.DataStore;
import com.santosh.entities.User;

public class UserDao {
public List<User> getUsers() {
	return DataStore.getUser();
}


}
