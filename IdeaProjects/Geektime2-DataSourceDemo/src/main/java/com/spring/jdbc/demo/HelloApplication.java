package com.spring.jdbc.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class HelloApplication {
	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}


	public void run(String... args) throws Exception{
		showConnection();
	}

	private void showConnection() throws SQLException{
		log.info(dataSource.toString());
		Connection connection = dataSource.getConnection();
		log.info(connection.toString());
		connection.close();
	}

}
