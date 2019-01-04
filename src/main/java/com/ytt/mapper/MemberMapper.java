package com.ytt.mapper;

import com.ytt.model.RUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<RUser> selectAll();

    RUser selectOne(String username, String password);

}
