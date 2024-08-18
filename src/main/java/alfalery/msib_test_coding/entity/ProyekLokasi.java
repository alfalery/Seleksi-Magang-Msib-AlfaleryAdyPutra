package alfalery.msib_test_coding.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proyek_lokasi")
public class ProyekLokasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proyek_id", nullable = false)
    private Proyek proyek;

    @ManyToOne
    @JoinColumn(name = "lokasi_id", nullable = false)
    private Lokasi lokasi;
}
