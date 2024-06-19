package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // 추상화 의존, 구체화 의존
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // => MemberRepository 인터페이스만 의존한다.
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
    
    // 추가
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
