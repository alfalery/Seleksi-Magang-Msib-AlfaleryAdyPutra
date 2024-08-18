package alfalery.msib_test_coding.service;

import alfalery.msib_test_coding.model.LokasiResponse;
import alfalery.msib_test_coding.model.CreateLokasiRequest;
import alfalery.msib_test_coding.model.UpdateLokasiRequest;

import java.util.List;

public interface LokasiService {
    LokasiResponse create(CreateLokasiRequest request);
    LokasiResponse get(Long id);
    LokasiResponse update(UpdateLokasiRequest request);
    void remove(Long id);
    List<LokasiResponse> list();
}
