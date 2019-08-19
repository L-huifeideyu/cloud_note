package org.tarena.note.dao;

import java.util.List;

import org.tarena.note.entity.NoteBook;

public interface BookDao {
	public int save(NoteBook book);

	public List<NoteBook> findByUserId(String userId);

	public int save(String bookName, String userId);
}
