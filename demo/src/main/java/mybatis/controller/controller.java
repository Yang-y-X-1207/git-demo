package mybatis.controller;

import mybatis.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mybatis.service.userService;

@RestController
public class controller {
    @Autowired
    userService userService;
    @RequestMapping("/delete")
    public void delete(){
        userService.delete();
        System.out.println("删除成功");
    }

    @RequestMapping("/select")
    public user select(int id){
        System.out.println("查询成功");
        return userService.select(id);
    }

    @RequestMapping("/add")
    public int add(user temp_user){
        System.out.println("添加成功");
        userService.insert(temp_user);
        System.out.println(temp_user.getId());
        return temp_user.getId();
    }

}
