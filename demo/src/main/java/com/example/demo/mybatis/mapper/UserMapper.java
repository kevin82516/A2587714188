package com.example.demo.mybatis.mapper;
import com.example.demo.mybatis.models.user;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<user> {
@Select("<script>SELECT * from user where id=1</script>")
    List<user> getdata();


}
