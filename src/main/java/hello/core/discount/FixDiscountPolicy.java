package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 조회 빈이 2개이상일 때 문제
// @Qualifier("fixDiscountPolicy") // 생성자, 수정자 매칭
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000 원 할인

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
