package alfalery.msib_test_coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import alfalery.msib_test_coding.entity.Lokasi;

import java.util.List;
import java.util.Optional;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Long> {

    Optional<Lokasi> findById(Long id);

    List<Lokasi> findAll();
}
