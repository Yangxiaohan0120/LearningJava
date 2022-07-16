package DevelopmentFrameWork.Mybatis.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @author Chris Yang
 * created 2022-07-16 16:47
 * C3P0与MyBatis兼容使用的数据源工厂类
 **/


public class C3P0DataSourceFactory extends UnpooledDataSourceFactory {
    public C3P0DataSourceFactory() {
        //
        this.dataSource = new ComboPooledDataSource();
    }
}
