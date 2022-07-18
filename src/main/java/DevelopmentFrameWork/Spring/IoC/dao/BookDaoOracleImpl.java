package DevelopmentFrameWork.Spring.IoC.dao;

/**
 * @author Chris Yang
 * created 2022-07-17 20:22
 **/
public class BookDaoOracleImpl implements BookDao{
    public void insert(){
        System.out.println("Oracle 数据库插入一条数据");
    }
}
