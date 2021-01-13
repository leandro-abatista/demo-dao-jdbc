package model.dao;

import model.dao.impl.VendedorDaoImplJDBC;

public class DaoFactory {
	
	public static VendedorDao createVendedorDao() {
		return new VendedorDaoImplJDBC();
	}

}
