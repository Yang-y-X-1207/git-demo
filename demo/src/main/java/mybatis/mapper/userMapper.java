package mybatis.mapper;

import mybatis.pojo.loginUser;
import mybatis.pojo.user;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;

@Mapper
public interface userMapper {

    @Delete("delete from user where id=#{id}")
    void deleteById(Integer id);

//    @Select("select * from user where id=#{id}")
    user selectById(Integer id);

    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into user(name,age,sex,dept_id) values(#{name},#{age},#{sex},#{dept_id})")
    void insert( user temp_user);


    @Select("select * from user where username=#{name} and password=#{password}")
    user selectByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
