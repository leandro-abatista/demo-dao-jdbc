package model.dao;

import db.DB;
import model.dao.impl.DepartamentoDaoImplJDBC;
import model.dao.impl.VendedorDaoImplJDBC;

public class DaoFactory {
	
	public static VendedorDao createVendedorDao() {
		return new VendedorDaoImplJDBC(DB.getConnection());
	}
	
	public static DepartamentoDao createDepartamentoDao() {
		return new DepartamentoDaoImplJDBC(DB.getConnection());
	}

}
