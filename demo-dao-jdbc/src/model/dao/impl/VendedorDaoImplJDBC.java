package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDaoImplJDBC implements VendedorDao{
	
	/*vou ter esse objeto conn a disposição em qualquer lugar da classe VendedorDaoImplJDBC*/
	private Connection conn;
	
	/*exemplo de outra forma de injeção de dependência*/
	public  VendedorDaoImplJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor findById(Long id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName " + 
					"FROM seller INNER JOIN department " + 
					"ON seller.DepartmentId = department.Id " + 
					"WHERE seller.Id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getLong("DepartmentId"));
				dep.setNome(rs.getString("DepName"));
				
				Vendedor ven = new Vendedor();
				ven.setId(rs.getLong("Id"));
				ven.setNome(rs.getString("Name"));
				ven.setEmail(rs.getString("Email"));
				ven.setDataNascimento(rs.getDate("BirthDate"));
				ven.setSalarioBase(rs.getDouble("BaseSalary"));
				ven.setDepartamento(dep);
				
				return ven;
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
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
