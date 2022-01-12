package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    //아래 코드는 불가능, private으로 막아놨기 때문.
    //MemberRepository memberRepository = new MemberRepository();

    MemberRepository memberRepository = MemberRepository.getInstance();

    //테스트 하나가 끝날때마다 실행.
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }
    //테스트의 순서는 보장이 안됨.
    //각 테스트 끝마다 clear를 하지 않았을 때
    //save()먼저 실행이 되고  finAll()을 실행하게 되면
    //memberRespository에 3개의 데이터가 들어가있는 상태이므로
    //findAll() 테스트는 실패가 뜬다.

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        //when
        memberRepository.save(member1);
        memberRepository.save(member2);

        //then
        List<Member> memberList = memberRepository.findAll();
        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(member1, member2);

    }
}
