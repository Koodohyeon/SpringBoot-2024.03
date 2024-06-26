package com.example.security.Service;

import java.util.List;

import com.example.security.entity.SecurityUser;

public interface SecurityUserService {
    public static final int COUNT_PER_PAGE = 10;

    SecurityUser getUserByUid(String uid);

    List<SecurityUser> getSecurityUserList(int page);

    int getSecurityUserCount();

    void insertSecurityUser(SecurityUser securityUser);

    void updateSecurityUser(SecurityUser securityUser);

    void deleteSecurityUser(String uid);

}