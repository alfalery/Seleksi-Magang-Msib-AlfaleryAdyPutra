package alfalery.msib_test_coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import alfalery.msib_test_coding.entity.Proyek;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Long> {

    
    Optional<Proyek> findById(Long id);

    List<Proyek> findAll();
    

    // You can add additional custom query methods if necessary, e.g., findByClient
}
