package com.example.security.Service;

import com.example.security.entity.MyUserDetails;
import com.example.security.entity.SecurityUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final SecurityUserService securityService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser securityUser = securityService.getUserByUid(username);

        if (securityUser != null) {
            log.info("Login 완료" + securityUser.getUid());
            return new MyUserDetails(securityUser);
        }
        return null;
    }
}
