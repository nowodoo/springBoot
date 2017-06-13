package com.zach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 在这里我们使用@SpringBootApplication指定这是一个 spring boot的应用程序.
 */
//extends WebMvcConfigurerAdapter  http://blog.csdn.net/cloume/article/details/48439429
@SpringBootApplication
public class App {
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
