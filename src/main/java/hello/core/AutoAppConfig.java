package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        basePackages = "hello.core", // 지정하지 않으면 AutoAppConfig가 있는 패키지와 그 하위 패키지들 탐색
        excludeFilters = @ComponentScan.Filter(
                // 전에 AppConfig 클래스를 제외할 것이기 때문에
                // Configuration 도 컴포넌트 대상이기 때문에 자동으로 등록되는 것을 방지(충돌 이슈)
                type = FilterType.ANNOTATION, classes = Configuration.class)
        )
public class AutoAppConfig {
//        자동 빈 vs 수동 빈
//        @Bean(name = "memoryMemberRepository")
//        public MemoryMemberRepository memoryMemberRepository() {
//                return new MemoryMemberRepository();
//        }
}
