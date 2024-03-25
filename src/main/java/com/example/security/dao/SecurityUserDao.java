package com.example.security.dao;

import com.example.security.Controller.SecurityUserController;
import com.example.security.entity.SecurityUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SecurityUserDao {

    @Select("select * from securityUser where uid=#{uid}")
    SecurityUser getUserByUid(String uid);

    @Select("select * from securityUser where isDeleted=0 order by regDate desc" +
            " limit #{count} offset #{offset}")
    List<SecurityUser> getSecurityUserList(int count, int offset);

    @Select("select count(uid) from securityUser where isDeleted=0")
    int getSecurityUserCount();

    @Insert("insert into securityUser values (#{uid}, #{pwd}, #{uname}, #{email}," +
            " default, default, #{picture}, #{provider}, default)")
    void insertSecurityUser(SecurityUser securityUser);

    @Update("update securityUser set pwd=#{pwd}, uname=#{uname}, email=#{email}," +
            " picture=#{picture} where uid=#{uid}")
    void updateSecurityUser(SecurityUser securityUser);

    @Update("update securityUser set isDeleted=1 where uid=#{uid}")
    void deleteSecurityUser(String uid);

}
