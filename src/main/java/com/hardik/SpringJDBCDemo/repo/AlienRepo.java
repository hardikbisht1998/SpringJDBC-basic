package com.hardik.SpringJDBCDemo.repo;

import com.hardik.SpringJDBCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AlienRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien){
        String sql="insert into alien (id, name, tech) values(?,?,?)";

        int rows=template.update(sql,alien.getId(),alien.getName(),alien.getTech());
        System.out.println(rows+" added");
    }

    public List<Alien> getAliens(){
        String query="Select * from alien";
        RowMapper rowMapper=new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien alien=new Alien();
                alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setTech(rs.getString(3));
                System.out.println(rowNum);
                return alien;
            }

        };
        return  template.query(query,rowMapper);
    }
}
