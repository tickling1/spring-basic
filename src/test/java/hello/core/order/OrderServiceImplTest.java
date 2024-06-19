package hello.core.order;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "memberA", Grade.VIP));
        // 수정자(Setter) 의존관계인 경우
        // createOrder 메서드를 사용하기 위해 어떤 데이터가 필요한지 알 수 없다.(직접 들어가서 봐야함)
        // OrderServiceImpl orderService = new OrderServiceImpl();

        // 생성자 의존관계일 경우
        // 생성자으로 지정하면 필수 값처럼 컴파일러가 알려줌
        // + final 키워드 쌉가능
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
        // NullPointerException: 가짜 더미 데이터라도 넣어줘야 한다.
        Order order = orderService.createOrder(1L, "itemA", 10000);
        
        // 검증 로직
        Assertions.assertThat(order.getMemberId()).isEqualTo(1L);
        Assertions.assertThat(order.getItemName()).isEqualTo("itemA");
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}