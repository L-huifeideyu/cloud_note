package org.tarena.note.aop;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//将异常记录文件,当切面使用
@Component
@Aspect
public class ExceptionHanlder {

	//ex参数作用：接收目标组件抛出的异常对象
	@AfterThrowing(throwing="ex",
	pointcut="within(org.tarena.note.controller..*)")
	public void hanlder(Exception ex){
		//将异常信息写入文件
		//System.out.println("发生异常了"+ex);
		try{
			FileWriter fw = 
				new FileWriter("note_error.log",true);
			PrintWriter pw = new PrintWriter(fw);
			ex.printStackTrace(pw);
			pw.flush();
			pw.close();
			fw.close();
		}catch(Exception e){
			System.out.println("记录异常日志失败");
		}
	}
	
}
