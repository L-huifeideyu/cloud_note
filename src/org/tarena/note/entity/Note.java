package org.tarena.note.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note implements Serializable{
	private String cn_note_id;
	private String cn_notebook_id;
	private String cn_user_id;
	private String cn_note_status_id;
	private String cn_note_type_id;
	private String cn_note_title;
	private String cn_note_body;
	private Timestamp cn_note_create_time;
	private Timestamp cn_note_last_modify_time;
	//��cn_note_create_timeֵת��YYYY-MM-dd�ַ���
	/*
	public String getCreateTime(){
		if(cn_note_create_time!=null){
			Date date = new Date(cn_note_create_time);
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		}else{
			return "";
		}
	}
	*/
	public String getCn_note_id() {
		return cn_note_id;
	}
	public void setCn_note_id(String cnNoteId) {
		cn_note_id = cnNoteId;
	}
	public String getCn_notebook_id() {
		return cn_notebook_id;
	}
	public void setCn_notebook_id(String cnNotebookId) {
		cn_notebook_id = cnNotebookId;
	}
	public String getCn_user_id() {
		return cn_user_id;
	}
	public void setCn_user_id(String cnUserId) {
		cn_user_id = cnUserId;
	}
	public String getCn_note_status_id() {
		return cn_note_status_id;
	}
	public void setCn_note_status_id(String cnNoteStatusId) {
		cn_note_status_id = cnNoteStatusId;
	}
	public String getCn_note_type_id() {
		return cn_note_type_id;
	}
	public void setCn_note_type_id(String cnNoteTypeId) {
		cn_note_type_id = cnNoteTypeId;
	}
	public String getCn_note_title() {
		return cn_note_title;
	}
	public void setCn_note_title(String cnNoteTitle) {
		cn_note_title = cnNoteTitle;
	}
	public String getCn_note_body() {
		return cn_note_body;
	}
	public void setCn_note_body(String cnNoteBody) {
		cn_note_body = cnNoteBody;
	}
	
    /*
     * public Long getCn_note_create_time() { return cn_note_create_time; }
     * public void setCn_note_create_time(Long cnNoteCreateTime) {
     * cn_note_create_time = cnNoteCreateTime; } public Long
     * getCn_note_last_modify_time() { return cn_note_last_modify_time; } public
     * void setCn_note_last_modify_time(Long cnNoteLastModifyTime) {
     * cn_note_last_modify_time = cnNoteLastModifyTime; }
     */
    public Timestamp getCn_note_create_time()
    {
        return cn_note_create_time;
    }

    public void setCn_note_create_time(Timestamp cn_note_create_time)
    {
        this.cn_note_create_time = cn_note_create_time;
    }

    public Timestamp getCn_note_last_modify_time()
    {
        return cn_note_last_modify_time;
    }

    public void setCn_note_last_modify_time(Timestamp cn_note_last_modify_time)
    {
        this.cn_note_last_modify_time = cn_note_last_modify_time;
    }
}
