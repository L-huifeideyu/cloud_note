package org.tarena.note.controller.book;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.BookService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/notebook")
public class AddBookController {
	@Resource
	private BookService bookService;

	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult execute(String bookName, String userId) {
		NoteResult result = bookService.addBook(bookName, userId);
		return result;
	}

}
