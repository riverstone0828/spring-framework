package co.kr.abacus.base.config.mybatis;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Objects;

@Configuration
public class MyBatisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean1() throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource1());
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return factoryBean;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean2() throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource2());
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return factoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        return new SqlSessionTemplate(Objects.requireNonNull(sqlSessionFactoryBean1().getObject()));
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception{
        return new SqlSessionTemplate(Objects.requireNonNull(sqlSessionFactoryBean2().getObject()));
    }
}
