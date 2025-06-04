package com.unifacisa.neomed.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.unifacisa.neomed.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico,Long> {

}


// public interface MedicoRepository extends CrudRepository <Medico, Long> { //

//Obs: Abella comentou na aula para utilizar CRUD Repository, caso seja necessário a mudança só retirar o comentário. //

