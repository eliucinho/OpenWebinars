/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.openwebinars.taller.app.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.openwebinars.taller.app.modelos.Auto;
import java.util.Optional;
import net.openwebinars.taller.app.repositorios.AutoRepositorio;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class AutoServicio {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int guardar(Auto entity) {
        String sql 
                = " INSERT INTO auto "
                + " (id,modelo,marca,anio,precio,fecha) "
                + " VALUES(?,?,?,?,?,?) ";
        return jdbcTemplate.update(sql,
                new Object[]{entity.getId(),
                    entity.getModelo(),
                    entity.getMarca(),
                    entity.getAnio(),
                    entity.getPrecio(),
                    entity.getFecha()});
    }

    public int actualizar(Auto entity) {
        String sql = " UPDATE auto "
                + " SET modelo=?,marca=?,anio=?,precio=?,fecha=? "
                + " where id=? ";
        return jdbcTemplate.update(sql,
                new Object[]{
                    entity.getModelo(),
                    entity.getMarca(),
                    entity.getAnio(),
                    entity.getPrecio(),
                    entity.getFecha(),
                    entity.getId()
                });
    }

    public void eliminar(Long id) {
        jdbcTemplate.update("DELETE FROM auto WHERE id=?", id);
    }

    public Auto getValor(Long id) {
        try {
            String sql="SELECT * FROM auto WHERE id=?";
            Auto auto = 
                    jdbcTemplate
                        .queryForObject(
                            sql
                            ,BeanPropertyRowMapper
                                .newInstance(Auto.class)
                            , id);
            return auto;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public List<Auto> getTodos() {
        String sql=" SELECT * from auto ";
        return jdbcTemplate
                .query(sql
                , BeanPropertyRowMapper
                .newInstance(Auto.class));
    }
}
