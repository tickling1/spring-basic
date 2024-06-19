//package hello.core.order;
//
//import hello.core.discount.DiscountPolicy;
//import hello.core.member.Member;
//import hello.core.member.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OrderServiceImplLombokBefore implements OrderService{
//
//    // private final MemberRepository memberRepository = new MemoryMemberRepository();
//    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    // 할인 정책 변경, OCP 원칙 위반, DIP 원칙 위반
//    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//
//    // 인터페이스만 의존하도록 변경 => DIP 원칙
//    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy;
//
//    // 중요! 생성자가 딱 1개만 있으면 @Autowired를 생략해도 자동 주입 된다. 물론 스프링 빈에만 해당한다.
//    // 생성자 주입 - 시기: 스프링 빈으로 등록하면서 어쩔수 없이 생성자 호출하면서 동시(등록, 주입))에
//    @Autowired
//    public OrderServiceImplLombokBefore(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }
//
////    // 수정자 주입(setter) - 시기: 스프링 빈 등록 후 의존관계 주입
////    @Autowired
////    public void setMemberRepository(MemberRepository memberRepository) {
////        System.out.println("memberRepository = " + memberRepository);
////        this.memberRepository = memberRepository;
////    }
////
////    // 수정자 주입(setter)
////    @Autowired
////    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
////        System.out.println("discountPolicy = " + discountPolicy);
////        this.discountPolicy = discountPolicy;
////    }
////
////    @Autowired // 일반 메서드 주입
////    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
////        this.memberRepository = memberRepository;
////        this.discountPolicy = discountPolicy;
////    }
//
//    @Override
//    public Order createOrder(Long memberId, String itemName, int itemPrice) {
//        Member member = memberRepository.findById(memberId);
//        int discountPrice = discountPolicy.discount(member, itemPrice);
//
//        return new Order(memberId, itemName, itemPrice, discountPrice);
//    }
//
//
//    // 테스트 용도 추가
//    public MemberRepository getMemberRepository() {
//        return memberRepository;
//    }
//}
