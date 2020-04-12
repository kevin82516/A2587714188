package com.example.demo.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.mybatis.models.user;
import com.example.demo.mybatis.models.test;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface testMapper extends BaseMapper<user> {
    @Select("<script>select a.id as id , a.name as name ,c.coco as coco , c.time as time from user a inner join coco c ON a.name=c.name order by id desc</script>")
    List<test> gettestlist();

    @Select("<script>select a.id as id , a.name as name ,c.coco as coco , c.time as time from user a inner join coco c ON  a.name=c.name where c.name=#{name} </script>")
    List<test> findnamelist(String name);

    @Select("<script>select a.id as id , a.name as name ,c.coco as coco , c.time as time from user a inner join coco c ON  a.name=c.name where c.name=#{name} <when test='time==1'>AND TO_DAYS(time) = TO_DAYS(NOW())</when></script>")
    List<test> fllowtime(String name,String time );
}
