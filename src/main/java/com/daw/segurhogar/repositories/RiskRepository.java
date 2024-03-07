package com.daw.segurhogar.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.daw.segurhogar.entities.Risk;

public interface RiskRepository extends JpaRepository<Risk, Long> {

	Optional<Risk> getRiskByNoCalle(String calle);

}
