package alfalery.msib_test_coding.service;

import alfalery.msib_test_coding.model.ProyekLokasiResponse;
import alfalery.msib_test_coding.model.CreateProyekLokasiRequest;

import java.util.List;

public interface ProyekLokasiService {
    ProyekLokasiResponse create(CreateProyekLokasiRequest request);
    List<ProyekLokasiResponse> getByProyekId(Long proyekId);
    List<ProyekLokasiResponse> getByLokasiId(Long lokasiId);
    void remove(Long proyekId, Long lokasiId);
    List<ProyekLokasiResponse> list();
}
