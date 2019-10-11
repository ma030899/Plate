package cn.test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.test.entity.Provice;
import cn.test.service.ProviceService;

@Controller

public class ProviceController {
	@Resource
	private ProviceService proviceService;
	@RequestMapping(value = "/proviceRecord")
    public @ResponseBody  Object getRecord(){
        List<Provice> list=proviceService.showProvices();
            return list;
    }
    @RequestMapping(value ="/provice")
    public String into(){
        return "showProvice";
    }
}
