package com.example.security.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
// Security가 로그인 POST 요청을 낚아채서 로그인을 진행시킴
// 로컬 로그인 - UserDetails를 구현
// 소셜 로그인 - OAuth2User 구현
@RequiredArgsConstructor        // 생성자를 만들지 않아도 만든거처럼 해줌
public class MyUserDetails implements UserDetails {
    private final SecurityUser securityUser;

    // 사용자의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {        // extends 상속 받은 모든것들이 들어가도 될때 ? 표시
        Collection<GrantedAuthority> collet = new ArrayList<>();
        collet.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return securityUser.getRole();
            }
        });
        return null;
    }

    @Override
    public String getPassword() {
        return securityUser.getPwd();
    }

    @Override
    public String getUsername() {
        return securityUser.getUid();
    }

    @Override
    public boolean isAccountNonExpired() {      // 만료되지 않은 계정
        if (securityUser.getIsDeleted() == 0)
            return true;
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
