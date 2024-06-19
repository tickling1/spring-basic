package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.order.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            // BeanNotOfRequiredTypeException
            // OrderService orderService = ac.getBean(beanDefinitionName, OrderService.class);
            Object bean = ac.getBean(beanDefinitionName); // 모든 타입의 빈을 꺼내야하기 때문에
            System.out.println("Name = " + beanDefinitionName + ", Object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
        //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("Name = " + beanDefinitionName + ", Object = " + bean);
            }
        }
    }

}
