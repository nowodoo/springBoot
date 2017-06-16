package com.zach.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class TemplateController {

    /**
	 * 返回html模板.
	 */
	@RequestMapping("/templates")
	public String helloHtml(Map<String,Object> map){
		map.put("hello","from TemplateController.helloHtml");

        //在这里的返回值就是页面的名称。
		return "hello";
	}
	
}