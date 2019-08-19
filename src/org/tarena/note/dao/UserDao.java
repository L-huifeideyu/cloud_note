package org.tarena.note.dao;

import org.tarena.note.entity.User;

public interface UserDao {

	public int save(User user);
	public User findByName(String name);
	
}
