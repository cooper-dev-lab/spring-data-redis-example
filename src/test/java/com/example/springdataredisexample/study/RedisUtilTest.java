package com.example.springdataredisexample.study;

import com.example.springdataredisexample.domain.Member;
import com.example.springdataredisexample.utils.RedisUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
public class RedisUtilTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    @DisplayName("strings: setTest")
    void stringsSet() {
        Member member = Member.of("member01");
        Member savedMember = redisUtils.setStrings(member);
        assertThat(member.getId()).isEqualTo(savedMember.getId());
    }

    @Test
    @DisplayName("strings: getTest(with null)")
    void stringsGet() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> redisUtils.getStrings("not saved id").orElseThrow(RuntimeException::new));
    }

    @Test
    @DisplayName("list 테스트")
    void list() {
        redisUtils.list();
    }

}
