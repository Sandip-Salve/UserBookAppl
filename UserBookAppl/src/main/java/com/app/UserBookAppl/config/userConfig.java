package com.app.UserBookAppl.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = {
		"com.app.UserBookAppl.user.repository" }, transactionManagerRef = "transactionManager")
public class userConfig {

	// Creating Datasource
	@Primary
	@Bean(name = "datasource")
	@ConfigurationProperties(prefix = "spring.user.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	// Creating EntityManagerFctory
	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("datasource") DataSource dataSource) {
		// hib. will create DB auto.
		// Specify dialect, hbm2ddl to create table manually
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update"); // to create table auto.
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"); // to find sql query
		// Injecting datasource inside EntityManagerFctory
		// specify which pkg need to be scan
		return builder.dataSource(dataSource).properties(properties).packages("com.app.UserBookAppl.model.user")
				.persistenceUnit("User").build();
	}

	// Creating TransactionMgr
	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
