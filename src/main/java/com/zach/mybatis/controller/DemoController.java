package com.zach.mybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.zach.mybatis.domain.Demo;
import com.zach.mybatis.mapper.DemoMappper;
import com.zach.mybatis.service.DemoService;
import com.zach.util.FastJsonConvert;
import com.zach.util.ObjectSerialzableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @Resource
    private DemoMappper demoMappper;

    @RequestMapping("/likeName")
    public List<Demo> likeName(String name) {
        return demoService.likeName(name);
    }

    @RequestMapping("/alipay")
    public String alipay(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectSerialzableUtil.ObjectSerialzable(HttpServletResponse.class.getName(), request, request);

        Map<String, String[]> parameterMap = request.getParameterMap();
        String string = JSONObject.toJSONString(parameterMap);

        String requestStr =  FastJsonConvert.convertObjectToJSON(request.getParameterMap());


//        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
//        StringBuffer sb = new StringBuffer("");
//        String temp;
//        while ((temp = br.readLine()) != null) {
//            sb.append(temp);
//        }
//        br.close();
//        String params = sb.toString();

        Demo demo = new Demo();
        demo.setName(requestStr);
        demoMappper.insert(demo);

        return "success";
    }

}