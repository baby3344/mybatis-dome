package cn.smbms.dao.user;
import java.util.List;
import cn.smbms.pojo.User;
public interface UserMapper {
    /**
     * 查询用户记录数
     * @return
     */
    int count();
    List<User> getUserList();
}
