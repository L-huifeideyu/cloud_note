package org.tarena.note.service;

import org.tarena.note.entity.Note;
import org.tarena.note.util.NoteResult;
import org.tarena.note.vo.SearchBean;

public interface NoteService {

	public NoteResult loadNote(String noteId);

	public NoteResult loadBookNotes(String bookId);

	public NoteResult save(Note note);
	public NoteResult saveBody(Note note);
}
