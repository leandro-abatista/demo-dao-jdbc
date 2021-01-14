package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ProductDao;
import model.entities.Product;

public class ProductDaoImplJDBC implements ProductDao {

	private Connection conn;

	public ProductDaoImplJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Product obj) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conn.prepareStatement(
					"INSERT INTO product (description, pricePucharse, priceSale, amount) VALUES (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getDescription());
			ps.setDouble(2, obj.getPricePurchase());
			ps.setDouble(3, obj.getPriceSale());
			ps.setInt(4, obj.getAmount());

			int rowsAffect = ps.executeUpdate();

			if (rowsAffect > 0) {
				rs = ps.getGeneratedKeys();

				if (rs.next()) {
					Long id = rs.getLong(1);
					obj.setId(id);
				}
			} else {
				throw new DbException("Erro inesperado, nenhuma linha foi afetada!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void update(Product obj) {

	}

	@Override
	public void deleteById(Long id) {

	}

	@Override
	public Product findById(Long id) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conn.prepareStatement("SELECT * FROM product WHERE Id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				Product prod = instantiateProduct(rs);
				return prod;
			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	private Product instantiateProduct(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setId(rs.getLong("Id"));
		product.setDescription(rs.getString("description"));
		product.setPricePurchase(rs.getDouble("pricePucharse"));
		product.setPriceSale(rs.getDouble("priceSale"));
		product.setAmount(rs.getInt("amount"));
		return product;
	}

	private Product instantiateProductPrice(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setId(rs.getLong("Id"));
		product.setPricePurchase(rs.getDouble("pricePucharse"));
		product.setPriceSale(rs.getDouble("priceSale"));
		return product;
	}

	@Override
	public List<Product> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conn.prepareStatement("SELECT * FROM product ORDER BY description");
			rs = ps.executeQuery();

			List<Product> list = new ArrayList<Product>();

			while (rs.next()) {
				Product prod = instantiateProduct(rs);
				list.add(prod);
			}
			return list;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Product> findAllPrice() {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conn.prepareStatement("SELECT * FROM product WHERE priceSale > 3000");
			rs = ps.executeQuery();

			List<Product> list = new ArrayList<Product>();

			while (rs.next()) {
				Product prod = instantiateProductPrice(rs);
				list.add(prod);
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
