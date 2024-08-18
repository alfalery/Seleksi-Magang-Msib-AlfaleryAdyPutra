package alfalery.msib_test_coding.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateLokasiRequest {

    @NotBlank
    @Size(max = 255)
    private String namaLokasi;

    @NotBlank
    @Size(max = 255)
    private String negara;

    @NotBlank
    @Size(max = 255)
    private String provinsi;

    @NotBlank
    @Size(max = 255)
    private String kota;

    // If `createdAt` is not part of the creation request, it can be omitted
}
