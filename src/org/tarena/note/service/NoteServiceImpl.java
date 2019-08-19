package org.tarena.note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Note;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.entity.Share;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;
import org.tarena.note.vo.SearchBean;

@Service
@Transactional
public class NoteServiceImpl implements NoteService
{
    @Resource
    private NoteDao noteDao;

    public NoteResult loadBookNotes(String bookId)
    {
        NoteResult result = new NoteResult();
        List<Note> noteList = noteDao.findByBookId(bookId);
        result.setStatus(0);
        result.setData(noteList);
        result.setMsg("查询笔记列表成功");
        return result;
    }

    public NoteResult loadNote(String noteId)
    {
        NoteResult result = new NoteResult();
        Note note = new Note();
        note = noteDao.findByNoteId(noteId);
        result.setStatus(0);
        result.setData(note);
        result.setMsg("获取笔记内容成功");
        return result;
    }

    public NoteResult save(Note note)
    {
        NoteResult result = new NoteResult();
        String noteId = NoteUtil.createId();
        note.setCn_note_id(noteId);
        note.setCn_note_status_id("1");
        note.setCn_note_type_id("1");
        noteDao.save(note);
        result.setStatus(0);
        result.setMsg("笔记添加成功");
        return result;
    }

    @Transactional(readOnly = false)
    public NoteResult saveBody(Note note)
    {
        // TODO Auto-generated method stub
        NoteResult result = new NoteResult();
        noteDao.saveBody(note);
        result.setStatus(0);
        result.setMsg("笔记更新成功");
        return result;
    }

}
