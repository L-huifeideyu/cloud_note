package org.tarena.note.service;

import org.tarena.note.util.NoteResult;

public interface BookService {
	public NoteResult loadBooks();

	public NoteResult addBook(String bookName, String userId);

	public NoteResult loadUserBooks(String userId);
}
