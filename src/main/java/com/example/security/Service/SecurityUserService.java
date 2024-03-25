package com.example.security.Service;

import com.example.security.entity.SecurityUser;

import java.util.List;

public interface SecurityUserService {
    public static final int COUNT_PER_PAGE = 10;

    SecurityUser getUserByUid(String uid);

    List<SecurityUser> getSecurityUserList(int page);

    int getSecurityUserCount();

    void insertSecurityUser(SecurityUser securityUser);

    void updateUser(SecurityUser securityUser);

  //  void registerUser(SecurityUser securityUser);

    void deleteUser(String uid);
}
