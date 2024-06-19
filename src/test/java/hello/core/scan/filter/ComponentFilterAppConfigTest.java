package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.junit.jupiter.api.Assertions.*;

public class ComponentFilterAppConfigTest {
    @Configuration
    @ComponentScan(
            includeFilters = {
                    @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class)
            },
            excludeFilters = {
                    @ComponentScan.Filter(classes = MyExcludeComponent.class),
                    // BeanA도 빼고싶다면 다음과 같이 추가
                    // @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BeanA.class)
            }
            // type = FilterType.ANNOTATION <- 기본값, 생략 가능
    )
    static class ComponentFilterAppConfig {

    }


    @Test
    void filterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class)); // 오류, 컴포넌트 스캔 대상아님
    }
}
