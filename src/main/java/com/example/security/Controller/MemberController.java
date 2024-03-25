package com.example.security.Controller;

import com.example.security.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {

    @ResponseBody
    @GetMapping("/detail/{mid}")
    public String detail(@PathVariable int mid) {
        Member member = new Member();
        return "";
    }

    @GetMapping("/insert")
    public String insert() {
        Member m1 = new Member();
        m1.setName("james"); m1.setEmail("james@gmail.com");
        return "";
    }
}
