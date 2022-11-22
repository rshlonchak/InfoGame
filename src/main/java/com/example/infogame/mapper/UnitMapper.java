package com.example.infogame.mapper;

import com.example.infogame.models.Unit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitMapper implements RowMapper<Unit> {

    @Override
    public Unit mapRow(ResultSet rs, int rowNum) throws SQLException {
        Unit unit = new Unit();
        unit.setId(rs.getInt("id"));
        unit.setName(rs.getString("name"));
        unit.setDescription(rs.getString("description"));
        unit.setImage(rs.getString("image"));
        return unit;
    }
}
