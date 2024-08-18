package alfalery.msib_test_coding.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProyekResponse {

    private Long id;
    private String namaProyek;
    private String client;
    private LocalDateTime tglMulai;
    private LocalDateTime tglSelesai;
    private String pimpinanProyek;
    private String keterangan;
    private LocalDateTime createdAt;
    private List<LokasiResponse> lokasiList;

    // Public constructor
    public ProyekResponse(Long id, String namaProyek, String client, LocalDateTime tglMulai,
                          LocalDateTime tglSelesai, String pimpinanProyek, String keterangan,
                          LocalDateTime createdAt, List<LokasiResponse> lokasiList) {
        this.id = id;
        this.namaProyek = namaProyek;
        this.client = client;
        this.tglMulai = tglMulai;
        this.tglSelesai = tglSelesai;
        this.pimpinanProyek = pimpinanProyek;
        this.keterangan = keterangan;
        this.createdAt = createdAt;
        this.lokasiList = lokasiList;
    }

}