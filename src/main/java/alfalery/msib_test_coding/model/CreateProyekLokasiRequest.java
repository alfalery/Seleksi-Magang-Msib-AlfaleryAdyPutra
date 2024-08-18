package alfalery.msib_test_coding.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProyekLokasiRequest {

    @NotNull
    private Long proyekId;

    @NotNull
    private Long lokasiId;
}
