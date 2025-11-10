package mybatis.service;

import Utils.JwtUtils;
import mybatis.mapper.userMapper;
import mybatis.pojo.loginUser;
import mybatis.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class userService {
    @Autowired
    userMapper userMapper;
    public void delete(){
        userMapper.deleteById(4);
    }
    public user select(int id){
        user temp =new user();
        temp=userMapper.selectById(id);
        return temp;
    }
    public void insert(user temp_user){
        userMapper.insert(temp_user);
    }


    public loginUser loginService(user User) {
        user u  = userMapper.selectByNameAndPassword(User.getUsername(),User.getPassword());
        Map<String,Object> map = new HashMap<>();
        map.put("id",u.getId());
        map.put("username",u.getUsername());
        map.put("name",u.getName());
        if(u != null){
            return new loginUser(u.getId(),u.getUsername(),u.getName(),
                    JwtUtils.generateToken(map));
        }
        return null;
    }
}
