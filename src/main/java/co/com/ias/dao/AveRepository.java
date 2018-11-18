package co.com.ias.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ias.models.Ave;

public interface AveRepository extends JpaRepository<Ave, String>{
	
	@Query(value="SELECT DISTINCT A.CDAVE, A.IS_REMOVE, A.DSNOMBRE_CIENTIFICO, A.DSNOMBRE_COMUN " + 
			"FROM TONT_AVES A " + 
			"INNER JOIN TONT_AVES_PAIS AP ON AP.CDAVE = A.CDAVE " + 
			"INNER JOIN TONT_PAISES P ON P.CDPAIS = AP.CDPAIS " + 
			"INNER JOIN TONT_ZONAS Z ON Z.CDZONA = :zona " + 
			"WHERE A.DSNOMBRE_CIENTIFICO LIKE CONCAT('%',:nombreAve,'%') OR A.DSNOMBRE_COMUN LIKE CONCAT('%',:nombreAve,'%')", 
			nativeQuery=true)
	List<Ave> fetchAvesContainingName(@Param("nombreAve") String nombreAve, @Param("zona") String zona);
}