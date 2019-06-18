package com.woniu.dorm.handler;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.dorm.mapper.NightfallMapper;
import com.woniu.dorm.pojo.Nightfall;

import com.woniu.dorm.utils.Page;


@Controller
@RequestMapping("/nightfall")
public class NightFallHandler {
	@Resource
	private NightfallMapper nightfallService;
	
	
	
	public NightfallMapper getNightfallService() {
		return nightfallService;
	}



	public void setNightfallService(NightfallMapper nightfallService) {
		this.nightfallService = nightfallService;
	}



	@RequestMapping("/all")
	@ResponseBody
	public List<Nightfall> all(Page<Nightfall> page) {
		page.setIndex((page.getCurrentpage()-1)*page.getCount());
		List<Nightfall> list = nightfallService.all(page);
		
		
		return list;
	}
	@RequestMapping("/allpage")
	@ResponseBody
	public Page<Nightfall> allpage(Page<Nightfall> page){
		int total=nightfallService.total();
		System.out.println(total+"111");
		if (total%page.getCount()==0) {
			total=total/page.getCount();
		}
		else {
			total=total/page.getCount()+1;
		}
		System.out.println(total+"*8*");
		page.setToatalpage(total);
		return page;
	}
	@RequestMapping("/add")
	public String add(Nightfall nightfall) {
		System.out.println(nightfall);
		nightfallService.add(nightfall);
		
		return "redirect:/html/nightfall.jsp";
	}
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(Nightfall nightfall) {
		System.out.println(nightfall);
		nightfallService.delete(nightfall);
	}
	@RequestMapping("/select")
	@ResponseBody
	public List<Nightfall> select(Nightfall nightfall) {
		System.out.println(nightfall);
		if (nightfall.getStudent().getSname()==null) {
			Nightfall nightfall2 = new Nightfall();
			nightfall2.setNcouse(nightfall.getNcouse());
			nightfall2.setNdate(nightfall.getNdate());
			List<Nightfall> list = nightfallService.select(nightfall2);
			return list;
		}
		
		List<Nightfall> list = nightfallService.select(nightfall);
		return list;
	}
	
	
}
