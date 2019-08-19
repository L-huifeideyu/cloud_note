package org.tarena.note.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tarena.note.service.BookService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/notebook")
public class BookListController {
	@Resource
	private BookService bookService;

	@RequestMapping("/list.do")
	public String execute(Model model) {
		return "book_list";// ��book_list.jsp
	}

}
