package com.servipuedosv.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.servipuedosv.models.dao.IClienteDao;
import com.servipuedosv.models.entities.Cliente;


@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteDao customerDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) customerDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		customerDao.save(cliente);		
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findOne(Long cli_num_documento) {
		// TODO Auto-generated method stub
		return customerDao.findById(cli_num_documento).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long cli_num_documento) {
		// TODO Auto-generated method stub
		customerDao.deleteById(cli_num_documento);
	}

}
