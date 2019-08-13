package cn.smbms.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import cn.smbms.dao.user.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import cn.smbms.pojo.User;
import cn.smbms.utils.MyBatisUtil;
import org.junit.Test;

public class UserMapperTest {
	private Logger logger = Logger.getLogger(UserMapperTest.class);
	@Test
	public void testGetUserList(){
		SqlSession sqlSession=null;
		List<User> userList=new ArrayList<User>();
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			//使用映射器执行查询操作
			userList=sqlSession.getMapper(UserMapper.class).getUserList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSession(sqlSession);
		}
		for(User user:userList){
			logger.debug("testGetUserList userCode:"+user.getUserCode()+" and userName:"+user.getUserName());
		}
	}

	@Test
	public void test() {
		String resource = "mybatis-config.xml";
		int count =0;
		SqlSession sqlSession = null;
		try {
			//1 获取mybatis-config.xml的输入流
			InputStream is = Resources.getResourceAsStream(resource);
			//2 创建SqlSessionFactory对象，完成对配置文件的读取
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3 创建sqlSession
			sqlSession = factory.openSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			count = sqlSession.selectOne("cn.smbms.dao.user.UserMapper.count");
			logger.debug("UserMapperTest count---> " + count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
}
