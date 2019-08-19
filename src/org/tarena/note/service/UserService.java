package org.tarena.note.service;

import org.tarena.note.util.NoteResult;

public interface UserService {
	public NoteResult registUser(String username, String password, String nickname);

	public NoteResult checkLogin(String username, String password);
}
