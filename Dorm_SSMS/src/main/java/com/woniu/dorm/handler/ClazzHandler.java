package com.woniu.dorm.handler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.dorm.mapper.ClazzMapper;
import com.woniu.dorm.pojo.Clazz;
import com.woniu.dorm.pojo.Teacher;
import com.woniu.dorm.utils.Page;

@Controller
@RequestMapping("/clazz")
public class ClazzHandler extends MyExceptionHandler {
	@Resource
	private ClazzMapper clazzService;

	public ClazzMapper getClazzService() {
		return clazzService;
	}

	public void setClazzService(ClazzMapper clazzService) {
		this.clazzService = clazzService;
	}
	
	@RequestMapping("/all")
	@ResponseBody
	public List<Clazz> all(Page<Clazz> page) throws Exception {
		List<Clazz> clazzs = new ArrayList<Clazz>();
		
		page.setIndex((page.getCurrentpage()-1)*page.getCount());
		clazzs= clazzService.all(page);
		return clazzs;
		
	} 
	
	@RequestMapping("/allpage")
	@ResponseBody
	public Page<Clazz> allpage( Page<Clazz> page ) throws Exception {
				
		int count = page.getCount();
		int allpage = clazzService.allpage();
		if (allpage%count==0) {
			page.setToatalpage(allpage/count);
		}
		else {
			page.setToatalpage((allpage/count)+1);
		}	
		return page;
	}
	@RequestMapping("/add")
	public String add(@Validated Clazz clazz,BindingResult result, String tname) throws Exception {
		if (result.hasErrors()) {
		
			return "redirect:/html/clazz.jsp";
		}
		System.out.println(clazz);
	
		
	
		Teacher teachers = new Teacher();
		teachers.setTname(tname);
		clazz.setTeachers(teachers);
		clazzService.add(clazz);
		
		
		return "redirect:/html/clazz.jsp";
	}
	@RequestMapping("/delete")
	@ResponseBody
	public String delete( Clazz clazz ,BindingResult result) throws Exception {
		
		boolean delete = clazzService.delete(clazz);
		
		if (delete==false) {
			return "还有学生不能删除";
		}
		
		return null;
	}
	@RequestMapping("/total")
	@ResponseBody
	public List<Clazz> total() throws Exception{
		List<Clazz> clazzs = new ArrayList<Clazz>();
		clazzs = clazzService.total();
		return clazzs;
		
	}
	
}
