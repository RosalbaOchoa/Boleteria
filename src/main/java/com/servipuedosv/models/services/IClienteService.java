package com.servipuedosv.models.services;

import java.util.List;
import com.servipuedosv.models.entities.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long cli_num_documento);
	
	public void delete(Long cli_num_documento);

}
