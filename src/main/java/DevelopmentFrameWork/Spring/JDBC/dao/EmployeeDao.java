package DevelopmentFrameWork.Spring.JDBC.dao;

import DevelopmentFrameWork.Spring.JDBC.Entity.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Chris Yang
 * created 2022-07-18 22:23
 **/

@Repository
public class EmployeeDao {
    @Resource
    private JdbcTemplate jdbcTemplate;


    // @Deprecated
    //    @Nullable
    //    public <T> T queryForObject(String sql, @Nullable Object[] args, RowMapper<T> rowMapper) throws DataAccessException {
    //        List<T> results = (List)this.query((String)sql, (Object[])args, (ResultSetExtractor)(new RowMapperResultSetExtractor(rowMapper, 1)));
    //        return DataAccessUtils.nullableSingleResult(results);
    //    }
    //
    //    @Nullable
    //    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args) throws DataAccessException {
    //        List<T> results = (List)this.query((String)sql, (Object[])args, (ResultSetExtractor)(new RowMapperResultSetExtractor(rowMapper, 1)));
    //        return DataAccessUtils.nullableSingleResult(results);
    //    }
    public Employee findById(Integer eno) {
        String sql = "select * from employee where eno = ?";
        // BeanPropertyRowMapper 将bean的属性和每一行的列进行一一对应
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), new Object[]{eno});
        return employee;
    }

    public List<Employee> findByDname(String dname){
        String sql = "select * from employee where dname = ?";
        List<Employee> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Employee>(Employee.class),new Object[]{dname});
        return list;
    }

    public List findMapByDname(String dname){
        String sql = "select eno as empno , salary as s from employee where dname = ?";
        //将查询结果作为Map进行封装
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,new Object[]{dname});
        return list;
    }

    public void insert(Employee employee){
        String sql = "insert into employee(eno,ename,salary,dname,hiredate) values (?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{
           employee.getEno(),employee.getEname(),employee.getSalary(),employee.getDname(),employee.getHiredate()
        });
    }

    public int update(Employee employee){
        String sql = "UPDATE employee SET ename = ? , salary = ? , dname = ? , hiredate = ? where eno = ?";
        int count = jdbcTemplate.update(sql,new Object[]{employee.getEname(),employee.getSalary(),employee.getDname(),employee.getHiredate(),employee.getEno()});
        return count;
    }

    public int delete(Integer eno){
        String sql = "delete from employee where eno = ?";
        int count = jdbcTemplate.update(sql,new Object[]{eno});
        return count;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
