package com.jdbc;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {

    private DataSource dataSource;

    private SimpleJdbcInsert jdbcTemplate;
    // private NamedParameterJdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new SimpleJdbcInsert(dataSource).withTableName("Employee");
        //jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void insert(Employee employee) {
    String sql = "INSERT INTO Employee " +
        "(eid, name, mailID, salary) VALUES (:eid, :name, :emailID, :salary)";

    Map source=new HashMap();
    source.put("eid",employee.getEid());
    source.put("name",employee.getName());
    source.put("emailID",employee.getMailID());
    source.put("salary",employee.getSalary());

    /*MapSqlParameterSource source=new MapSqlParameterSource();
    source.addValue("pid",employee.getPid())
        .addValue("firstName",employee.getFirstName())
        .addValue("surName",employee.getSurName());

*/
     jdbcTemplate.execute(new BeanPropertySqlParameterSource(employee));
        //jdbcTemplate.update(sql,new BeanPropertySqlParameterSource(p));
        //jdbcTemplate.queryForList("select * from Persons");


    }

}
