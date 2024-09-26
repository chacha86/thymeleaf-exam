package com.example.thymeleafexam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LeafController {

    @RequestMapping("login-view")
    @ResponseBody
    public String loginView() {
        return """
                <form action="/login" method="post" >
                    <div>
                        <label>아이디</label>
                        <input name="loginId">
                    </div>
                    <div>
                        <label>비밀번호</label>
                        <input name="loginPw">
                    </div>
                    <input type="submit" value="로그인" />
                </form>
                """;
    }


    @RequestMapping("login")
    @ResponseBody
    public String login(String loginId, String loginPw) {
        String userId = "hong";
        String username = "홍길동";
        String userPw = "1234";

        if (!loginId.equals(userId) || !loginPw.equals(userPw)) {
            return """
                    <div>잘못된 회원 정보입니다</div>
                    <a href="/login-view">로그인</a>
                    """;
        }

        return "안녕하세요 %s님! 반갑습니다.".formatted(username);

    }
}
