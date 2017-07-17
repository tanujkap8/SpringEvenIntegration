package com.ATMApplication;

import com.jdbc.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


public class UserDaoImpl implements UserDao {

    private DataSource dataSource;

    ApplicationContext context;

    public static double bal;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public boolean withdrawal(User user, double money) {
        if(user.getBalance()>money) {
            bal = money;
            jdbcTemplate.update("Update User set balance = ? where name = ?", user.getBalance()-money, user.getName());
            context = new ClassPathXmlApplicationContext("AsyncMessage.xml");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean changeATMPIN(User user, int PIN) {
        jdbcTemplate.update("Update User set atmPIN = ? where name = ?", PIN, user.getName());
        return true;
    }

    @Override
    public boolean changeMobileNumber(User user, long mobileNumber) {
        jdbcTemplate.update("Update User set mobileNumber = ? where name = ?", mobileNumber, user.getName());
        context = new ClassPathXmlApplicationContext("Beans.xml");
        AlertForMobileNumberUpdate alert = context.getBean(AlertForMobileNumberUpdate.class);
        alert.alertUpdate();
        return true;
    }

    @Override
    public void insert(User user) {
        jdbcTemplate.update("INSERT INTO User (name, balance, atmPIN, mobileNumber) VALUES (?,?,?,?)", user.getName(), user.getBalance(), user.getAtmPIN(), user.getMobileNumber());
    }
}
