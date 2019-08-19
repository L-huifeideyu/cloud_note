package org.tarena.note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.UserService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserRegistController {
	@Resource
	private UserService userService;

	@RequestMapping("/regist.do")
	@ResponseBody
	public NoteResult execute(String username, String password, String nickname) {
		NoteResult result = userService.registUser(username, password, nickname);
		return result;
	}

}
