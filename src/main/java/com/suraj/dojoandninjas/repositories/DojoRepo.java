package com.suraj.dojoandninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.suraj.dojoandninjas.models.Dojo;


@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long>{
	
    List<Dojo> findAll();
    Optional<Dojo> findById(Long id);
    Dojo save(Dojo d);
    void deleteById(Long id);
    
}
