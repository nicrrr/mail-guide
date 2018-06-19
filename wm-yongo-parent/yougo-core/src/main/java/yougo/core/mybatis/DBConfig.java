//package yougo.core.mybatis;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
//@Configuration
//@EnableAutoConfiguration
//public class DBConfig {
//	
//	@Value("${spring.datasource.url}")
//	private String url;
//	
//	@Value("${spring.datasource.username}")
//	private String username;
//	
//	@Value("${spring.datasource.password}")
//	private String password;
//	
//	/**
//	 * 
//	 * description:配置数据源
//	 * @return
//	 * @author nicr
//	 * date: 2018年6月19日 下午2:11:00
//	 */
//	@Bean(initMethod = "init", destroyMethod = "close")
//	public DataSource getDataSource() {
//		DruidDataSource druidDataSource = new DruidDataSource();
//		druidDataSource.setUrl(url);
//		druidDataSource.setUsername(username);
//		druidDataSource.setPassword(password);
//		druidDataSource.setInitialSize(10);//初始化时建立物理连接的个数。
//        druidDataSource.setMaxActive(30);//最大连接池数量
//        druidDataSource.setMinIdle(10);//最小连接池数量
//        druidDataSource.setMaxWait(60000);//最大等待时间
//        druidDataSource.setRemoveAbandoned(true);//是否自动回收超时连接
//        druidDataSource.setRemoveAbandonedTimeout(600);//自动回收超时时间
//        druidDataSource.setLogAbandoned(true);//关闭abanded连接时输出错误日志
//		return druidDataSource;
//	}
//	
//	/**
//	 * 
//	 * description:获取SqlSessionFactory
//	 * @return
//	 * @throws Exception
//	 * @author nicr
//	 * date: 2018年6月19日 下午2:20:51
//	 */
//	@Bean
//	public SqlSessionFactory getSqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//		//设置数据源
//		sqlSessionFactory.setDataSource(getDataSource());
//		//设置mapper读取的地址
//		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mybatis/**/*.xml"));
//		return sqlSessionFactory.getObject();
//	}
//	
//	/**
//	 * 
//	 * description:获取SqlSessionTemplate
//	 * @return
//	 * @throws Exception
//	 * @author nicr
//	 * date: 2018年6月19日 下午2:21:53
//	 */
//	@Bean
//    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(getSqlSessionFactory());
//        return sqlSessionTemplate;
//    }
//
//}
