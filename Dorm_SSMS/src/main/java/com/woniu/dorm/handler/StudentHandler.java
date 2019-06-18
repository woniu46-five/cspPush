package com.woniu.dorm.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.dorm.mapper.StudentMapper;

import com.woniu.dorm.pojo.Student;
import com.woniu.dorm.utils.ImgPath;
import com.woniu.dorm.utils.Page;
import com.woniu.dorm.utils.Validationclazz;

@Controller
@RequestMapping("/student")
public class StudentHandler extends MyExceptionHandler{
	@Resource
	private StudentMapper studentService;
	
	
	public StudentMapper getStudentService() {
		return studentService;
	}


	public void setStudentService(StudentMapper studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/all")
	@ResponseBody
	public List<Student> all(Page<Student> page) throws Exception {
	
		List<Student> students = new ArrayList<Student>();

		page.setIndex((page.getCurrentpage()-1)*page.getCount());
		students = studentService.all(page);
			
	
		return students;
	}
	@RequestMapping("/allpage")
	@ResponseBody
	public Page<Student> allpage(Page<Student> page) throws Exception{
		
		int total = studentService.total();
		int count = page.getCount();
		
		if (total%count==0) {
			page.setToatalpage(total/count);
		}
		else {
			page.setToatalpage((total/count)+1);
		}	
		return page;
	}
	@RequestMapping("/add")
	public String add(@Validated Student student,BindingResult result) throws IllegalStateException, IOException,Exception {
	if (result.hasErrors()) {
		List<FieldError> errors = result.getFieldErrors();
		Iterator<FieldError> iterator = errors.iterator();
		while (iterator.hasNext()) {
			FieldError fieldError = (FieldError) iterator.next();
			System.out.println(fieldError.getField()+"," +fieldError.getDefaultMessage());//获取错误信息
			
		}
		return "redirect:/html/student.jsp";
	}
		
		
		
		String imgpath = ImgPath.imgpath(student.getImg());
		System.out.println(imgpath);
		student.setSimg(imgpath);
		studentService.add(student);
		return "redirect:/html/student.jsp";
	}
	@RequestMapping("/delete")
	public String delete(Student student)throws Exception {
		
		studentService.delete(student);
		return "redirect:/html/student.jsp";
	}
	@RequestMapping("/show")
	@ResponseBody
	public Student show(Student student) throws Exception {
		
		student=studentService.show(student);
		return student;
	}
	@RequestMapping("/change")
	@ResponseBody
	public void change(Student student) throws Exception {
		
		studentService.change(student);
		
	}
	@RequestMapping("/select")
	@ResponseBody
	public List<Student> select (Student student) throws Exception{
		List<Student> students = new ArrayList<Student>();
		
		students = studentService.select(student);
		return students;
	}
	
	
}
