package org.tarena.note.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.BookService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/notebook")
public class LoadUserBooksController {
	@Resource
	private BookService bookService;

	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult execute(String userId) {
		NoteResult result = bookService.loadUserBooks(userId);
		return result;
	}

}
