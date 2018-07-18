package cn.wodesh.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DruidConfig {

    private static final Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Bean
    @Primary
    public DataSource dataSource(DataSoruceBean dataSoruceBean) {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dataSoruceBean.getDbUrl());
        datasource.setUsername(dataSoruceBean.getUsername());
        datasource.setPassword(dataSoruceBean.getPassword());
        datasource.setDriverClassName(dataSoruceBean.getDriverClassName());
        //configuration
        datasource.setInitialSize(dataSoruceBean.getInitialSize());
        datasource.setMinIdle(dataSoruceBean.getMinIdle());
        datasource.setMaxActive(dataSoruceBean.getMaxActive());
        datasource.setMaxWait(dataSoruceBean.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(dataSoruceBean.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(dataSoruceBean.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(dataSoruceBean.getValidationQuery());
        datasource.setTestWhileIdle(dataSoruceBean.getTestWhileIdle());
        datasource.setTestOnBorrow(dataSoruceBean.getTestOnBorrow());
        datasource.setTestOnReturn(dataSoruceBean.getTestOnReturn());
        datasource.setPoolPreparedStatements(dataSoruceBean.getPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(dataSoruceBean.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            datasource.setFilters(dataSoruceBean.getFilters());
        } catch (SQLException e) {
            logger.info("druid configuration initialization filter: " + e);
        }
        datasource.setConnectionProperties(dataSoruceBean.getConnectionProperties());
        return datasource;
    }

    @Bean
    public ServletRegistrationBean druidServlet(DataSoruceBean dataSoruceBean) {
        logger.info("init Druid Servlet Configuration ");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // IP白名单
        servletRegistrationBean.addInitParameter("allow", dataSoruceBean.getAllow());
        // IP黑名单(共同存在时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", dataSoruceBean.getDeny());
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", dataSoruceBean.getLoginUsername());
        servletRegistrationBean.addInitParameter("loginPassword", dataSoruceBean.getLoginPassword());
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", dataSoruceBean.getResetEnable());
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
