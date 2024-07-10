package com.crud.senaicrud;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
public class DataConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://localhost:3306/db_crudsenai?user=root&password=root");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        // adapter.setDatabase(Database.MARIADB);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
adapter.setDatabasePlatform("org.hibernate.dialect.MariaDBDialect");
        adapter.setPrepareConnection(true);
        return adapter;        

    }

}
