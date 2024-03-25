package com.example.security.Controller;

import com.example.security.Service.SecurityUserService;
import com.example.security.entity.SecurityUser;
import com.example.security.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class SecurityUserController {
    private final SecurityUserService securityService;
    private final BCryptPasswordEncoder bCryptEncoder;
    private final ImageUtil imageUtil;
    @Value("${spring.servlet.multipart.location}") private String uploadDir;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "user/register";
    }

    @PostMapping("/register")
    public String registerProc(String uid, String pwd, String pwd2, String uname, String email,
                               MultipartHttpServletRequest req, Model model) {
        String filename = null;
        MultipartFile filePart = req.getFile("picture");

        SecurityUser securityUser = securityService.getUserByUid(uid);
        if (securityUser != null) {
            model.addAttribute("msg", "사용자 ID가 중복되었습니다.");
            model.addAttribute("url", "/ss/user/register");
            return "common/alertMsg";
        }
        if (pwd == null || !pwd.equals(pwd2)) {
            model.addAttribute("msg", "비밀번호 입력이 잘못되었습니다..");
            model.addAttribute("url", "/ss/user/login");
            return "common/alertMsg";
        }
        if (filePart.getContentType().contains("image")) {
            filename = filePart.getOriginalFilename();	// 이게 왜 들어가는 거
            String path = uploadDir + "profile/" + filename;
            try {
                filePart.transferTo(new File(path));
            } catch (Exception e) {
                e.printStackTrace();
            }
            filename = imageUtil.squareImage(uid, filename);
        }
        String hashedPwd = bCryptEncoder.encode(pwd);
        SecurityUser se = SecurityUser.builder()
                .uid(uid).pwd(hashedPwd).uname(uname).email(email)
                .picture("/ss/file/download/profile/" + filename).provider("ck world")
                .build();
        securityService.insertSecurityUser(securityUser);
        model.addAttribute("msg", "등록을 마쳤습니다. 로그인하세요.");
        model.addAttribute("url", "/ss/user/login");



        return "common/alertMsg";
    }
}
