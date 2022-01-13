package sh.love.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = {"sh.love.mapper"}, sqlSessionFactoryRef = "sqlSessionFactoryMybatis")
public class MybatisDatabaseConfig {

    @Primary
    @Bean(name = "dataSourceMybatis")
    @ConfigurationProperties(prefix = "spring.datasource.mybatis-config")
    public DataSource dataSourceMybatis() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "sqlSessionFactoryMybatis")
    public SqlSessionFactory sqlSessionFactoryMybatis(@Qualifier("dataSourceMybatis") DataSource dataSourceMybatis, ApplicationContext appContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceMybatis);
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:config/sqlmapper/sql-mapper-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(appContext.getResources("classpath:config/sqlmapper/query/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplateMybatis")
    public SqlSessionTemplate sqlSessionTemplateMybatis(SqlSessionFactory sqlSessionFactoryMybatis) {
        return new SqlSessionTemplate(sqlSessionFactoryMybatis);
    }

}
