package com.proa.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proa.app.dao.IClienteDAO;
import com.proa.app.entities.Client;
import com.proa.app.exceptions.ClientNotFoundException;

@Service
public class ServiceImpl implements IService {
	
	@Autowired
	private IClienteDAO dao;
	
	@Override
	public boolean insert(Client c) {
		Client response=null;
		
		if(c.getId()==0) {
			response = dao.save(c);
		}
		//var response=dao.save(c);//var permite implentar una referencia dinamiva,, toma el tipo de dato de la variable 
		
		return response!=null;
	}

	@Override
	public List<Client> selectAll() {
		
		return (List<Client>)dao.findAll();
	}

	@Override
	public boolean update(Client c) throws ClientNotFoundException{
		if(dao.existsById(c.getId())) {
			var response=dao.save(c);
			return response!=null;
		} 
		
		throw new ClientNotFoundException("Client " + c.getId()+" not found");
		
	}

	@Override
	public Client findById(long id) throws ClientNotFoundException{
		
		return dao.findById(id)
				.orElseThrow(
						()->new ClientNotFoundException("Client " + id +" not found")
						);
	}

	@Override
	public boolean delete(long id) throws ClientNotFoundException{
		
		if(dao.existsById(id)){
			dao.deleteById(id);
			return true;
		}
		
		throw new ClientNotFoundException("Client " + id +" not found");
	}

}
