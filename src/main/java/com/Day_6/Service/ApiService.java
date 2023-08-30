package com.Day_6.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Day_6.Model.Child;
import com.Day_6.Repository.ChildRepo;

@Service
public class ApiService {
	@Autowired
	ChildRepo cr;
	public List<Child> saveninfo(List<Child> ee) {
		return (List<Child>)cr.saveAll(ee);//POST	
	}
	public List<Child> sortinfo(String field){
		return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,field));
	}
	public List<Child> getbypage(int pgno,int pgsize){
		Page<Child> p=cr.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	}
	public List<Child> getPages(int pno, int psize, String field)
	{
		Sort ord = Sort.by(Sort.DEFAULT_DIRECTION,field);
		Page<Child> b = cr.findAll(PageRequest.of(pno, psize,ord));
		return b.getContent();
		
	}
}
