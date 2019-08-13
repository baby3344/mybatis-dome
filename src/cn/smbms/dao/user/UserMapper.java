package cn.smbms.dao.user;
import java.util.List;
import cn.smbms.pojo.User;
public interface UserMapper {
    int count();
    List<User> getUserList();
}
