package com.servipuedosv.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.servipuedosv.models.entities.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
