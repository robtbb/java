package model.services;

import java.util.List;
import model.dao.FabricaDao;
import model.dao.ServicoDao;
import model.entities.Servico;

public class ServicoDeServicoLavacao {
	ServicoDao servicoDao = FabricaDao.createServicoDao();
	
	public List<Servico> buscaTodos(){
		return servicoDao.findAll();
	}
	public List<Servico> bustaTodosServicoPorIdDaCategoria(Integer IdDaCategoria){
		return servicoDao.findAllPorCategoria(IdDaCategoria);
	}
	public Servico buscaServicoPelaDescricaoDaCategoria(String nomeServicoOferecido, String descricaoDaCategoria){
		return servicoDao.findServPorTipoECategoria(nomeServicoOferecido, descricaoDaCategoria);
	}
}
