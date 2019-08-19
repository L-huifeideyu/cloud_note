package org.tarena.note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.note.dao.UserDao;
import org.tarena.note.entity.User;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	public NoteResult checkLogin(String username, String password) {
		NoteResult result = new NoteResult();
		//1.�ж��û����Ƿ���ڣ����������ֱ�ӷ��ش���
		User user = userDao.findByName(username);
		if(user == null){
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;
		}		
		//2.�ж������Ƿ���ȷ������������ֱ�ӷ��ش���
		//�����ж���md5
		String pwd = NoteUtil.md5(password);
		if(!pwd.equals(user.getCn_user_password())){
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		
		//3.�û���������ȷ�����������ǰ̨
		result.setStatus(0);
		result.setData(user.getCn_user_id());
		result.setMsg("��¼�ɹ���");
		//0�ɹ� 1�û��������� 2���벻����
		return result;
	}

	public NoteResult registUser(String username, String password, String nickname) {
		NoteResult result = new NoteResult();
		User dbUser = userDao.findByName(username);
		if(dbUser != null){
			result.setMsg("�û����Ѵ���");
			result.setStatus(0);
			return result;
		}
		User user = new User();
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);
		user.setCn_user_name(username);
		String md5_password = NoteUtil.md5(password);
		user.setCn_user_password(md5_password);
		user.setCn_user_desc(nickname);
		user.setCn_user_token(null);
		userDao.save(user);
		result.setStatus(1);
		result.setMsg("ע��ɹ���");
		return result;
	}

}
