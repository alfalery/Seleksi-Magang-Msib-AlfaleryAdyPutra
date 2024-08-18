package alfalery.msib_test_coding.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProyekRequest {

    @NotBlank
    @Size(max = 255)
    private String namaProyek;

    @NotBlank
    @Size(max = 255)
    private String client;

    @NotNull
    private LocalDateTime tglMulai;

    @NotNull
    private LocalDateTime tglSelesai;

    @NotBlank
    @Size(max = 255)
    private String pimpinanProyek;

    private String keterangan;

    private List<Long> lokasiIds; // List of location IDs to associate with the project
}
