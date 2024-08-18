package alfalery.msib_test_coding.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;  // Import for LocalDateTime

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LokasiResponse {

    private Long id;

    private String namaLokasi;

    private String negara;

    private String provinsi;

    private String kota;

    private LocalDateTime createdAt;
}
