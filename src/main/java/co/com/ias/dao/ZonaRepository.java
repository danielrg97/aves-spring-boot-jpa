package co.com.ias.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ias.models.Zona;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, String>{

}
