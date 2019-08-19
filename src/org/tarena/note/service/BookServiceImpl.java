package org.tarena.note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.note.dao.BookDao;
import org.tarena.note.dao.BookJoinDao;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Resource
	private BookDao bookDao;

	@Resource
	private BookJoinDao joinDao;

	@Transactional(readOnly = true)
	public NoteResult loadUserBooks(String userId) {
		NoteResult result = new NoteResult();
		List<NoteBook> noteBookList = bookDao.findByUserId(userId);
		result.setStatus(0);
		result.setMsg("获取笔记本列表成功");
		result.setData(noteBookList);
		return result;
	}

	@Transactional(readOnly = false)
	public NoteResult addBook(String bookName, String userId) {
		NoteResult result = new NoteResult();
		NoteBook notebook = new NoteBook();
		String bookId = NoteUtil.createId();
		Timestamp time = new Timestamp(System.currentTimeMillis());
		notebook.setCn_notebook_id(bookId);
		notebook.setCn_notebook_createtime(time);
		notebook.setCn_notebook_name(bookName);
		notebook.setCn_user_id(userId);
		notebook.setCn_notebook_type_id("5");
		bookDao.save(notebook);
		result.setStatus(0);
		result.setMsg("创建笔记本成功");
		//result.setData(res);
		return result;
	}

	public NoteResult loadBooks() {
		NoteResult result = new NoteResult();
		// List<NoteBook> noteBookList = bookDao.findByUserId(userId);
		result.setStatus(0);
		result.setMsg("��ѯ���ݳɹ�");
		// result.setData(noteBookList);
		return result;
	}

}
