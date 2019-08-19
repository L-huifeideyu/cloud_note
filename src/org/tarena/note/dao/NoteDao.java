package org.tarena.note.dao;

import java.util.List;

import org.tarena.note.entity.Note;
import org.tarena.note.vo.SearchBean;

public interface NoteDao {
	
	public Note findById(String id);
	public List<Note> findByBookId(String bookId);
	public Note findByNoteId(String noteId);
	public int save(Note note);
	public int saveBody(Note note);
}
