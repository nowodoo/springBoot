package com.zach;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 在这里我们使用@SpringBootApplication指定这是一个 spring boot的应用程序.
 */
//extends WebMvcConfigurerAdapter  http://blog.csdn.net/cloume/article/details/48439429
@SpringBootApplication
public class App {

//    /**
//     * 使用fastJson需要覆盖的方法
//     * 1、需要先定义一个 convert 转换消息的对象;
//     * 2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
//     * 3、在convert中添加配置信息.
//     * 4、将convert添加到converters当中.
//     * @param converters
//     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//
//        // 1、需要先定义一个 convert 转换消息的对象;
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//
//        //2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//        //3、在convert中添加配置信息.
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//
//        //4、将convert添加到converters当中.
//        converters.add(fastConverter);
//    }

    /**
     * 使用第二种方法添加fastJson
     * 在这里我们使用 @Bean注入 fastJsonHttpMessageConvert
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1、需要先定义一个 convert 转换消息的对象;
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        //3、在convert中添加配置信息.
        fastConverter.setFastJsonConfig(fastJsonConfig);


        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }


    public static void main(String[] args) {
        /**
         * 这是springloader的配置方式：-javaagent:.\lib\springloaded-1.2.4.RELEASE.jar -noverify
         * @param args
         */
        /*
         * 在main方法进行启动我们的应用程序.
		 */
        SpringApplication.run(App.class, args);
    }
}
