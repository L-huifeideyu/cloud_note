package org.tarena.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.entity.Note;
import org.tarena.note.service.NoteService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class LoadNoteController {

	@Resource
	private NoteService noteService;

	@RequestMapping("/load.do")
	@ResponseBody
	public NoteResult execute(String noteId) {
		NoteResult result = noteService.loadNote(noteId);
		return result;
	}
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult addNote(Note note) {
		NoteResult result = noteService.save(note);
		return result;
	}
	
	@RequestMapping("/saveBody.do")
	@ResponseBody
	public NoteResult saveBody(Note note) {
		NoteResult result = noteService.saveBody(note);
		return result;
	}
}
