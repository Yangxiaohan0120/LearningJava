package DevelopmentFrameWork.Spring.IoC.service;

import DevelopmentFrameWork.Spring.IoC.dao.BookDao;

/**
 * @author Chris Yang
 * created 2022-07-17 18:44
 **/
public class BookService {

    private BookDao bookDao;

    public void purchase(){
        System.out.println("正在执行图书采购业务方法");
        bookDao.insert();
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
