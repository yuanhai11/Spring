package test;

import com.service.UserService;
import com.wxt.BeanDefinition;
import com.wxt.BeanFactory;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test0(){
        BeanFactory factory = new BeanFactory();
        BeanDefinition definition = new BeanDefinition(new UserService());
        factory.registerBeanDefinition("userService",definition);


        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();
    }

}
