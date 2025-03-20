package com.proa.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.proa.app.entities.Client;

public interface IClienteDAO extends CrudRepository<Client, Long>{

}
