package alfalery.msib_test_coding.service;

import alfalery.msib_test_coding.model.ProyekResponse;
import alfalery.msib_test_coding.model.CreateProyekRequest;
import alfalery.msib_test_coding.model.UpdateProyekRequest;

import java.util.List;

public interface ProyekService {
    ProyekResponse create(CreateProyekRequest request);
    ProyekResponse get(Long id);
    ProyekResponse update(UpdateProyekRequest request);
    void remove(Long id);
    List<ProyekResponse> list();
}
