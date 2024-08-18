package alfalery.msib_test_coding.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class LokasiResponse {

    private Long id;
    private String namaLokasi;
    private String negara;
    private String provinsi;
    private String kota;
    private LocalDateTime createdAt;

    // Public constructor
    public LokasiResponse(Long id, String namaLokasi, String negara, String provinsi,
                          String kota, LocalDateTime createdAt) {
        this.id = id;
        this.namaLokasi = namaLokasi;
        this.negara = negara;
        this.provinsi = provinsi;
        this.kota = kota;
        this.createdAt = LocalDateTime.now();
    }
}
