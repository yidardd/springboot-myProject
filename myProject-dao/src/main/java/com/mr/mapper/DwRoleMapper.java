package com.mr.mapper;


import com.mr.pojo.DwRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DwRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DwRole record);

    DwRole selectByPrimaryKey(Long id);
}