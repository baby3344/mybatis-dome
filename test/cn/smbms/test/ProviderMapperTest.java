package cn.smbms.test;

import cn.smbms.dao.provider.ProviderMapper;
import cn.smbms.pojo.Provider;
import cn.smbms.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProviderMapperTest {
    private static Logger logger=Logger.getLogger(ProviderMapperTest.class);

    /**
     * 上机1
     */
    @Test
    public void test1(){
        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            count = sqlSession.getMapper(ProviderMapper.class).count();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        logger.debug("一共"+count+"条记录");
    }

    /**
     * 上机二
     * 通过SqlSession实例来执行已映射的SQL语句
     */
   @Test
    public void test2(){
        SqlSession sqlSession=null;
        List<Provider> list=new ArrayList<Provider>();
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            //使用selectList方法执行查询操作
            list=sqlSession.selectList("cn.smbms.dao.provider.ProviderMapper.list");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        for (Provider provider:list) {
            logger.debug("proCode:"+provider.getProCode()+"and proName:"+provider.getProName());
        }
    }

    /**
     * 上机二
     * 基于mapper接口方式操作数据
     */
    @Test
    public void test3(){
        SqlSession sqlSession=null;
        List<Provider> list=new ArrayList<Provider>();
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            //使用selectList方法执行查询操作
            list=sqlSession.getMapper(ProviderMapper.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        for (Provider provider:list) {
            logger.debug("proCode:"+provider.getProCode()+"and proName:"+provider.getProName());
        }
    }
}
