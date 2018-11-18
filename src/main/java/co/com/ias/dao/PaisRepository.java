package co.com.ias.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ias.models.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, String>{

}
