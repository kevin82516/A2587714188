package com.example.demo.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.mybatis.models.user;
import org.apache.ibatis.annotations.Select;
import com.example.demo.mybatis.models.coco;

import java.util.List;

public interface cocoMapper extends BaseMapper<coco> {
    @Select("<script>SELECT * from user where id=1</script>")
    List<user> getdata();

}