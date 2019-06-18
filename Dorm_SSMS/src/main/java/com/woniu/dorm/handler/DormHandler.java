package com.woniu.dorm.handler;

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

import com.woniu.dorm.mapper.BreakdownMapper;
import com.woniu.dorm.mapper.DormMapper;
import com.woniu.dorm.pojo.Breakdown;

import com.woniu.dorm.pojo.Dorm;
import com.woniu.dorm.pojo.Dormtype;
import com.woniu.dorm.utils.DormDes;
import com.woniu.dorm.utils.Page;

@Controller
@RequestMapping("/dorm")
public class DormHandler extends MyExceptionHandler{
	@Resource
	private DormMapper dormService;
	@Resource
	private BreakdownMapper breakdownService;
	

	public BreakdownMapper getBreakdownService() {
		return breakdownService;
	}

	public void setBreakdownService(BreakdownMapper breakdownService) {
		this.breakdownService = breakdownService;
	}

	public DormMapper getDormService() {
		return dormService;
	}

	public void setDormService(DormMapper dormService) {
		this.dormService = dormService;
	}
	@RequestMapping("/all")
	@ResponseBody
	public List<Dorm> all(Page<Dorm> page) throws Exception{
		List<Dorm> dorms = new ArrayList<Dorm>();
	
		page.setIndex((page.getCurrentpage()-1)*page.getCount());
		dorms = dormService.all(page);
		return dorms;
		
	}
	@RequestMapping("/allpage")
	@ResponseBody
	public Page<Dorm> allpage( Page<Dorm> page) throws Exception {
	
		
		int count = page.getCount();
		int allpage = dormService.allpage();
		if (allpage%count==0) {
			page.setToatalpage(allpage/count);
		}
		else {
			page.setToatalpage((allpage/count)+1);
		}	
		return page;
	}
	
	@RequestMapping("/add")
	public String add(@Validated Dorm dorm,BindingResult result) throws Exception {
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			Iterator<FieldError> iterator = errors.iterator();
			while (iterator.hasNext()) {
				FieldError fieldError = (FieldError) iterator.next();
				System.out.println(fieldError.getField()+"," +fieldError.getDefaultMessage());//获取错误信息
				
			}
			return "redirect:/html/room.jsp";
		}
		
		if (dorm.getDcount()==0) {
			dorm.setPerson("不可住房间");
		}
		else {
			dorm.setPerson("可住房间");
		}
	
		dorm.setBreakdown("正常");
		dormService.insertdorm(dorm);
		return "redirect:/html/room.jsp";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Dorm dorm) throws Exception {
		boolean deletedorm = dormService.deletedorm(dorm);
		if (deletedorm==false) {
			return "还有学生，该房间不能删除";
		}
		return null;
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public Dorm show( Dorm dorm) throws Exception {
	
		dorm = dormService.show(dorm);
	
		return dorm;
	}
	
	@RequestMapping("/addbreak")
	@ResponseBody
	public String add(@Validated Breakdown breakdown,BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return null;
		}
		
		breakdownService.insertbreak(breakdown);
	
		return null;
	}

	@RequestMapping("/rbreak")
	@ResponseBody
	public String remove(Breakdown breakdown) {
		
		breakdownService.rbreak(breakdown);
		return null;
	}
	
	@RequestMapping("/select")
	@ResponseBody
	public List<Dorm> select(DormDes des) throws Exception{
	
		Dorm dorm = new Dorm();
		if (des.getAddress()!=null) {
			dorm.setDaddress(des.getAddress());
		}
		if (!des.getBreakdowns().equals("不限")) {
			dorm.setBreakdown(des.getBreakdowns());
		}
		if (!des.getPersonal().equals("不限")) {
			dorm.setPerson(des.getPersonal());
		}
		if (!des.getDormtype().equals("不限")) {
			if (des.getDormtype().equals("男生宿舍")) {
				Dormtype dormtype = new Dormtype();
				dormtype.setTypeid(1);
				dorm.setType(dormtype);
			}
			else {
				Dormtype dormtype = new Dormtype();
				dormtype.setTypeid(2);
				dorm.setType(dormtype);
			}
		}
		List<Dorm> list = dormService.myselect(dorm);
		
		
		return list;
	}
	@RequestMapping("/total")
	@ResponseBody
	public List<Dorm> total() throws Exception{
		List<Dorm> dorms = new ArrayList<Dorm>();
		dorms = dormService.total();
		return dorms;
	}

	
}
