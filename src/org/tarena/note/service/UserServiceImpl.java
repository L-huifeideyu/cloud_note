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
		//1.判断用户名是否存在，如果不存在直接返回错误
		User user = userDao.findByName(username);
		if(user == null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}		
		//2.判断密码是否正确，如果密码错误直接返回错误
		//密码判断用md5
		String pwd = NoteUtil.md5(password);
		if(!pwd.equals(user.getCn_user_password())){
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		
		//3.用户名密码正确，将结果返回前台
		result.setStatus(0);
		result.setData(user.getCn_user_id());
		result.setMsg("登录成功！");
		//0成功 1用户名不存在 2密码不存在
		return result;
	}

	public NoteResult registUser(String username, String password, String nickname) {
		NoteResult result = new NoteResult();
		User dbUser = userDao.findByName(username);
		if(dbUser != null){
			result.setMsg("用户名已存在");
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
		result.setMsg("注册成功！");
		return result;
	}

}
