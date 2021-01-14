package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class DepartamentoDaoImplJDBC implements DepartamentoDao {

	/*
	 * vou ter esse objeto conn a disposição em qualquer lugar da classe
	 * DepartamentoDaoImplJDBC
	 */
	private Connection conn;

	/* exemplo de outra forma de injeção de dependência */
	public DepartamentoDaoImplJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Departamento obj) {

	}

	@Override
	public void update(Departamento obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		

	}

	private Departamento instantiateDepartment(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getLong("Id"));
		dep.setNome(rs.getString("Name"));
		return dep;
	}

	@Override
	public Departamento findById(Long id) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				Departamento dep = instantiateDepartment(rs);
				return dep;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Departamento> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
			rs = ps.executeQuery();
			
			List<Departamento> list = new ArrayList<Departamento>();
			
			while (rs.next()) {
				Departamento depart = instantiateDepartment(rs);
				list.add(depart);
			}
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

}
