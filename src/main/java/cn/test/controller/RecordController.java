package cn.test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.test.entity.Record;
import cn.test.service.RecordService;


@Controller
public class RecordController {
	@Resource
	private RecordService recordService;
	 @RequestMapping(value = "/record")
	    public @ResponseBody  Object getColor(){
	        List<Record> list=recordService.showcolor();
	            return list;
	    }
	    @RequestMapping(value ="/color")
	    public String ColorInto(){
	        return "showColor";
	        //showColor
	    }
}
