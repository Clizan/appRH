package com.AppRH.AppRH;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

	@Bean
	public DataSource dataSource() {
	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/AppRH?useTimezone=true&serverTimeZone=UTC");
		dataSource.setUsername("aplicacao");
		dataSource.setPassword("");
		
		return dataSource;
		
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdpter() {
		
		HibernateJpaVendorAdapter adpter = new HibernateJpaVendorAdapter();
		adpter.setDatabase(Database.MYSQL);
		adpter.setShowSql(true);
		adpter.setGenerateDdl(true);
		adpter.setDatabasePlatform("org.hibernate.dialect.MariaDBDialect");
		adpter.setPrepareConnection(true);
		
		return adpter;
		
	}
	
}
