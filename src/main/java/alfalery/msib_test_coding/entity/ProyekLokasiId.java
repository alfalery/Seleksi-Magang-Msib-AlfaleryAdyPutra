package alfalery.msib_test_coding.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProyekLokasiId implements Serializable {
    private Long proyekId;
    private Long lokasiId;

    // Default constructor
    public ProyekLokasiId() {}

    // Parameterized constructor
    public ProyekLokasiId(Long proyekId, Long lokasiId) {
        this.proyekId = proyekId;
        this.lokasiId = lokasiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProyekLokasiId that = (ProyekLokasiId) o;
        return Objects.equals(proyekId, that.proyekId) &&
               Objects.equals(lokasiId, that.lokasiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proyekId, lokasiId);
    }
}
