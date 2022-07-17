package DevelopmentFrameWork.Mybatis.dao;

import DevelopmentFrameWork.Mybatis.Entity.emp;
import DevelopmentFrameWork.Mybatis.dto.empDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Chris Yang
 * created 2022-07-16 23:27
 **/
public interface empDAO {
    @Select("select * from t_emp where sal between #{min} and #{max} order by sal limit 0,#{limit}")
    public List<emp> selectByPriceRange(@Param("min") Double min, @Param("max") Double max, @Param("limit") Integer limit);

    @Insert("INSERT INTO t_emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (#{empno},#{ename},#{job},#{mgr},#{hiredate},#{sal},#{comm},#{deptno})")
    @SelectKey(statement = "select last_insert_id()", before = false, keyProperty = "empno", resultType = Integer.class)
    public int insert(emp p);

}
