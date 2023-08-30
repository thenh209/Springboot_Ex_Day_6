package com.Day_6.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Day_6.Model.Child;
import com.Day_6.Service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService cs;
	@PostMapping("addn")//adding n details
	public List<Child> addnstudents(@RequestBody List<Child> ee) {
		return cs.saveninfo(ee);
	}
	@GetMapping("sort/{field}")
	public List<Child> getsortinfo(@PathVariable String field){
		return cs.sortinfo(field);
	}
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<Child> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize){
		return cs.getbypage(pageno, pagesize);
	}
	@GetMapping("sortPage")
	public List<Child> sortPages(@RequestParam(value = "pNo") int pNo, @RequestParam(value = "pSize") int pSize,@RequestParam(value = "field") String field)
	{
		return cs.getPages(pNo, pSize, field);
	}

}
