package com.xebia.testauthentication;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class App 
{
    public static void main( String[] args )
    {
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
        UserInfo userInfo = (UserInfo)factory.getBean("userInfo");
        
        LoginService loginService = new LoginService();
        loginService.authenticate(userInfo.getUsername());
    }
}
