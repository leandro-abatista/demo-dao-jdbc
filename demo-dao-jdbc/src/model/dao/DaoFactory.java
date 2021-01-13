package model.dao;

import db.DB;
import model.dao.impl.VendedorDaoImplJDBC;

public class DaoFactory {
	
	public static VendedorDao createVendedorDao() {
		return new VendedorDaoImplJDBC(DB.getConnection());
	}

}
