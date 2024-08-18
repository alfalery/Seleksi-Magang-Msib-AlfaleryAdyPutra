package alfalery.msib_test_coding.service.impl;

import alfalery.msib_test_coding.entity.Lokasi;
import alfalery.msib_test_coding.model.LokasiResponse;
import alfalery.msib_test_coding.model.CreateLokasiRequest;
import alfalery.msib_test_coding.model.UpdateLokasiRequest;
import alfalery.msib_test_coding.repository.LokasiRepository;
import alfalery.msib_test_coding.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LokasiServiceImpl implements LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    @Transactional
    @Override
    public LokasiResponse create(CreateLokasiRequest request) {
        Lokasi lokasi = new Lokasi();
        lokasi.setNamaLokasi(request.getNamaLokasi());
        lokasi.setNegara(request.getNegara());
        lokasi.setProvinsi(request.getProvinsi());
        lokasi.setKota(request.getKota());

        lokasi = lokasiRepository.save(lokasi);
        return toLokasiResponse(lokasi);
    }

    private LokasiResponse toLokasiResponse(Lokasi lokasi) {
        return LokasiResponse.builder()
                .id(lokasi.getId())
                .namaLokasi(lokasi.getNamaLokasi())
                .negara(lokasi.getNegara())
                .provinsi(lokasi.getProvinsi())
                .kota(lokasi.getKota())
                .createdAt(lokasi.getCreatedAt())
                .build();
    }

    @Transactional(readOnly = true)
    @Override
    public LokasiResponse get(Long id) {
        Lokasi lokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lokasi is not found"));

        return toLokasiResponse(lokasi);
    }

    @Transactional
    @Override
    public LokasiResponse update(UpdateLokasiRequest request) {
        Lokasi lokasi = lokasiRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lokasi is not found"));

        lokasi.setNamaLokasi(request.getNamaLokasi());
        lokasi.setNegara(request.getNegara());
        lokasi.setProvinsi(request.getProvinsi());
        lokasi.setKota(request.getKota());

        lokasi = lokasiRepository.save(lokasi);
        return toLokasiResponse(lokasi);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Lokasi lokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lokasi is not found"));

        lokasiRepository.delete(lokasi);
    }

    @Transactional(readOnly = true)
    @Override
    public List<LokasiResponse> list() {
        List<Lokasi> lokasiList = lokasiRepository.findAll();
        return lokasiList.stream().map(this::toLokasiResponse).collect(Collectors.toList());
    }
}
