package alfalery.msib_test_coding.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "lokasi")
@Getter
@Setter
public class Lokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_lokasi")
    private String namaLokasi;

    @Column(name = "negara")
    private String negara;

    @Column(name = "provinsi")
    private String provinsi;

    @Column(name = "kota")
    private String kota;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
