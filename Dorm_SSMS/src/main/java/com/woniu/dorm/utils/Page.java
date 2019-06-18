package com.woniu.dorm.utils;

import java.util.List;

public class Page <T>{
	private int currentpage;
	private int count;
	private int toatalpage;
	private List<T> content;
	private int index;
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getToatalpage() {
		return toatalpage;
	}
	public void setToatalpage(int toatalpage) {
		this.toatalpage = toatalpage;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public String toString() {
		return "Page [currentpage=" + currentpage + ", count=" + count + ", toatalpage=" + toatalpage + ", content="
				+ content + ", index=" + index + "]";
	}

}
