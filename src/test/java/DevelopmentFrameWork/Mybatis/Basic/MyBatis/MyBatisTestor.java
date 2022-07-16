package DevelopmentFrameWork.Mybatis.Basic.MyBatis;

import DevelopmentFrameWork.Mybatis.Entity.habbit;
import DevelopmentFrameWork.Mybatis.dto.empDTO;
import DevelopmentFrameWork.Mybatis.Entity.emp;
import Utils.MyBatisUtils.MyBatisUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chris Yang
 * created 2022-07-15 14:27
 **/
public class MyBatisTestor {

    @Test
    public void testSqlSessionFactory() throws IOException {
        // 加载配置文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

        // 初始化对象，解析xml文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        System.out.println("sqlSessionFactory加载成功");

        SqlSession sqlSession = null;
        try {
            // 创建sqlSession对象，JDBC的扩展类，与数据库交互
            sqlSession = sqlSessionFactory.openSession();

            // 创建数据库连接（测试用），mybatis会自动进行连接，并不需要显式应用
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                // 如果mybatis中设置了"POOLED"使用连接池的方式，close会将连接回收到连接池
                // 如果使用的是"UNPOOLED"，代表直连，就会调用Connection.close()关闭连接。
                sqlSession.close();
            }
        }
    }

    @Test
    public void testMyBatisUtils() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
            MyBatisUtils.closeSession(sqlSession);
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List<emp> list = sqlSession.selectList("emp.selectAll");
            for (emp p : list) {
                System.out.println(p.getEmpno());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectByName() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            emp emp = sqlSession.selectOne("emp.selectByName", "SMITH");
            System.out.println(emp.getEmpno());
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectByPriceRange() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Map param = new HashMap();
            param.put("min", 100);
            param.put("max", 2000);
            param.put("limit", 10);
            List<emp> list = sqlSession.selectList("selectByPriceRange", param);
            for (emp p : list) {
                System.out.println(p.getEmpno() + ": " + p.getEname() + ", " + p.getSal());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectempMap(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();

            List<Map> list = sqlSession.selectList("selectempMap");
            for (Map map : list) {
                System.out.println(map);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectempDTO(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();

            List<empDTO> list = sqlSession.selectList("selectempDTO");
            for (empDTO empDTO : list) {
                System.out.println(empDTO.getP().getEname());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            emp emp = new emp();
            emp.setEmpno(7935);
            emp.setEname("Chris");
            emp.setJob("MANAGER");
            emp.setMgr(7999);
            emp.setHiredate(new Date(2022,7,15));
            emp.setSal(5000.00);
            emp.setComm(1200.00);
            emp.setDeptno(10);

            // 返回本次插入成功的记录总数
            int num = sqlSession.insert("insert",emp);
            // 提交事务数据
            sqlSession.commit();
            System.out.println(emp.getEmpno());
        } catch (Exception e) {
            if(sqlSession != null){
                sqlSession.rollback(); // 回滚事务
            }
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            emp emp = sqlSession.selectOne("selectByName","Chris");
            emp.setEname("Hanna");
            int num = sqlSession.update("update",emp);
            sqlSession.commit();
        } catch (Exception e) {
            if(sqlSession != null){
                sqlSession.rollback();
            }
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            int num = sqlSession.delete("delete","Hanna");
            sqlSession.commit();
        } catch (Exception e) {
            if(sqlSession != null){
                sqlSession.rollback();
            }
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectByJob() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Map param = new HashMap();
//            param.put("job","'CLERK'");
            param.put("job","''or 1=1 or job = 'CLERK'");

//            param.put("order"," order by empno desc");
            List<emp> list = sqlSession.selectList("emp.selectByJob", param);
            for(emp p : list){
                System.out.println(p.getEmpno() + ":" + p.getJob());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testDynamicSQL() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Map param = new HashMap();
            param.put("job","CLERK");
            param.put("empno",7900);
            List<emp> list = sqlSession.selectList("emp.dynamicSQL", param);
            for(emp p : list){
                System.out.println(p.getEmpno() + ":" + p.getJob());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testLvlCache() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            emp emp = sqlSession.selectOne("emp.selectByName", "SMITH");
            emp emp1 = sqlSession.selectOne("emp.selectByName","SMITH");
            System.out.println(emp.getEmpno());
            System.out.println(emp1.getEmpno());
            System.out.println(emp.hashCode() + " : " + emp1.hashCode());
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testLvlCache1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            emp emp = sqlSession.selectOne("emp.selectByName", "SMITH");
            emp emp1 = sqlSession.selectOne("emp.selectByName","SMITH");
            System.out.println(emp.getEmpno());
            System.out.println(emp1.getEmpno());
            System.out.println(emp.hashCode() + " : " + emp1.hashCode());
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }

        try {
            sqlSession = MyBatisUtils.openSession();
            emp emp = sqlSession.selectOne("emp.selectByName", "SMITH");
            emp emp1 = sqlSession.selectOne("emp.selectByName","SMITH");
            System.out.println(emp.getEmpno());
            System.out.println(emp1.getEmpno());
            System.out.println(emp.hashCode() + " : " + emp1.hashCode());
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testselectOnetoMany(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List<emp> list = sqlSession.selectList("emp.selectOnetoMany");
            for(emp p : list){
                System.out.println(p.getEmpno() + ":" + p.getHabbits().size());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testselectManytoOne(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List<habbit> list = sqlSession.selectList("habbit.selectManytoOne");
            for(habbit h : list){
                System.out.println(h.getIndex() + ":" + h.getHabbit() + ":" + h.getEmp().getEname());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectPage(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            PageHelper.startPage(2,10);
            // 返回Page
            Page<emp> page = (Page) sqlSession.selectList("emp.selectPage");
            System.out.println("总页数" + page.getPages());
            System.out.println("总记录数" + page.getTotal());
            System.out.println("开始行号" + page.getStartRow());
            System.out.println("结束行号" + page.getEndRow());
            System.out.println("当前页码" + page.getPageNum());
            List<emp> data = page.getResult();
            for (emp p : data){
                System.out.println(p.getEname());
            }
            System.out.println("");
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

}
