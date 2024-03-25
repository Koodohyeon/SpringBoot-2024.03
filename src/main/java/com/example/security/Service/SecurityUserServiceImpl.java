package com.example.security.Service;

import com.example.security.dao.SecurityUserDao;
import com.example.security.entity.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityUserServiceImpl implements SecurityUserService{
 //   private SecurityUserDao securityUserDao;
 //   @Autowired
 //   public SecurityUserServiceImpl(SecurityUserDao securityUserDao) {
 //      this.securityUserDao = securityUserDao;
 //  }
    private final SecurityUserDao securityDao;

    @Override
    public SecurityUser getUserByUid(String uid) {
        return securityDao.getUserByUid(uid);
    }

    @Override
    public List<SecurityUser> getSecurityUserList(int page) {
        int count = COUNT_PER_PAGE;
        int offset = (page - 1) * COUNT_PER_PAGE;
        return securityDao.getSecurityUserList(count, offset);
    }

    @Override
    public int getSecurityUserCount() {
        return securityDao.getSecurityUserCount();
    }

    @Override
    public void insertSecurityUser(SecurityUser securityUser) {
        securityDao.insertSecurityUser(securityUser);
    }

    @Override
    public void updateUser(SecurityUser securityUser) {
        securityDao.updateSecurityUser(securityUser);
    }

    @Override
    public void deleteUser(String uid) {
        securityDao.deleteSecurityUser(uid);
    }
}
