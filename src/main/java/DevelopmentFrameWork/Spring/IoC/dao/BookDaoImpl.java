package DevelopmentFrameWork.Spring.IoC.dao;

/**
 * @author Chris Yang
 * created 2022-07-17 18:42
 **/
public class BookDaoImpl implements BookDao{
    public void insert(){
        System.out.println("向MySql Book插入一条数据");
    }
}
