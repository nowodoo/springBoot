package com.zach;

import com.zach.domain.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 在这里我们使用RestController  （等待于 @Controller 和 @RequestBody）
 * @author zach
 */
@RestController
public class HelloController {
	
	/**
	 * 在这里我们使用@RequestMapping 建立请求映射:
	 * http://127.0.0.1:8080/hello
	 */
	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}

    /**
     * 测试返回json
     * @return
     */
    @RequestMapping("/getDemo")
    public Demo getDemo(){
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("张三");
        demo.setCreateTime(new Date());
        demo.setRemarks("这是备注信息");
        return demo;
    }
}
