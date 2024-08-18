package alfalery.msib_test_coding.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UpdateLokasiRequest {

    @JsonIgnore
    @NotBlank
    private Long id;

    @Size(max = 255)
    private String namaLokasi;

    @Size(max = 255)
    private String negara;

    @Size(max = 255)
    private String provinsi;

    @Size(max = 255)
    private String kota;

    // You can omit createdAt if it's not allowed to be updated
}
