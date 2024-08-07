package model.dao;

import db.DB;
import model.dao.impl.ClienteDaoJDBC;
import model.dao.impl.CorDaoJDBC;
import model.dao.impl.ECategoriaDaoJDBC;
import model.dao.impl.EStatusDaoJDBC;
import model.dao.impl.ETipoCombustivelDaoJDBC;
import model.dao.impl.MarcaDaoJDBC;
import model.dao.impl.ModeloJDBC;
import model.dao.impl.MotorDaoJDBC;
import model.dao.impl.ServicoDaoJDBC;

public class FabricaDao {
	
	public static ECategoriaDao createECategoriaDao() {
		return new ECategoriaDaoJDBC(DB.getConnection());
	}
	
	public static ETipoCombustivelDao createETipoCombustivelDao() {
		return new ETipoCombustivelDaoJDBC(DB.getConnection());
	}
	
	public static EStatusDao createEStatusDao() {
		return new EStatusDaoJDBC(DB.getConnection());
	}
	
	public static CorDao createCorDao() {
		return new CorDaoJDBC(DB.getConnection()); 
	}
	
	public static MarcaDao createMarcaDao() {
		return new MarcaDaoJDBC(DB.getConnection());
	}
	
	public static ModeloDao createModeloDao() {
		return new ModeloJDBC(DB.getConnection());
	}
	
	public static MotorDao createMotorDao() {
		return new MotorDaoJDBC(DB.getConnection());
	}
	
	public static ServicoDao createServicoDao() {
		return new ServicoDaoJDBC(DB.getConnection());
	}
	
	public static ClienteDao createClienteDao() {
		return new ClienteDaoJDBC(DB.getConnection());
	}
	
}
