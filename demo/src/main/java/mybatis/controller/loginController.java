package mybatis.controller;

import mybatis.pojo.Result;
import mybatis.pojo.loginUser;
import mybatis.pojo.user;
import mybatis.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    @Autowired
    private userService userService;
    @PostMapping("/login")
    public Result login(@RequestBody user User) {
        loginUser loginUser = userService.loginService(User);
        if(loginUser != null){
            return new Result(
                    1,
                    "登录成功",
                    loginUser
            );
        }
        return new Result(
                0,
                "登录失败",
                " "
        );
    }
}
