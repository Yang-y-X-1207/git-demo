package mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class user {
    private Integer id;
    private String name;
    private int age;
    private String sex;
    private int dept_id;
    private String username;
    private String password;
}
