package alfalery.msib_test_coding.repository;

import alfalery.msib_test_coding.entity.ProyekLokasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, Long> {
    
    List<ProyekLokasi> findByProyekId(Long proyekId);

    List<ProyekLokasi> findByLokasiId(Long lokasiId);

    Optional<ProyekLokasi> findByProyekIdAndLokasiId(Long proyekId, Long lokasiId);
}
