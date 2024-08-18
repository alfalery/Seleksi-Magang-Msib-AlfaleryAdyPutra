package alfalery.msib_test_coding.service.impl;

import alfalery.msib_test_coding.entity.Proyek;
import alfalery.msib_test_coding.entity.Lokasi;
import alfalery.msib_test_coding.model.LokasiResponse;
import alfalery.msib_test_coding.model.ProyekResponse;
import alfalery.msib_test_coding.model.CreateProyekRequest;
import alfalery.msib_test_coding.model.UpdateProyekRequest;
import alfalery.msib_test_coding.repository.ProyekRepository;
import alfalery.msib_test_coding.repository.LokasiRepository;
import alfalery.msib_test_coding.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashSet;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
@Transactional
public class ProyekServiceImpl implements ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    @Override
    public List<ProyekResponse> list() {
        List<Proyek> proyekList = proyekRepository.findAll(); // Mengambil semua proyek dari repository
        return proyekList.stream()
                .map(proyek -> new ProyekResponse(
                        proyek.getId(),
                        proyek.getNamaProyek(),
                        proyek.getClient(),
                        proyek.getTglMulai(),
                        proyek.getTglSelesai(),
                        proyek.getPimpinanProyek(),
                        proyek.getKeterangan(),
                        proyek.getCreatedAt(),
                        proyek.getLokasi() != null ? proyek.getLokasi().stream().map(this::convertToLokasiResponse).collect(Collectors.toList()) : null
                ))
                .collect(Collectors.toList()); // Mengonversi daftar proyek menjadi daftar ProyekResponse
    }

    @Override
    public ProyekResponse get(Long id) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyek with ID " + id + " not found"));

        return new ProyekResponse(
                proyek.getId(),
                proyek.getNamaProyek(),
                proyek.getClient(),
                proyek.getTglMulai(),
                proyek.getTglSelesai(),
                proyek.getPimpinanProyek(),
                proyek.getKeterangan(),
                proyek.getCreatedAt(),
                proyek.getLokasi() != null ? proyek.getLokasi().stream().map(this::convertToLokasiResponse).collect(Collectors.toList()) : null
        );
    }

    @Override
    public ProyekResponse create(CreateProyekRequest request) {
        Proyek proyek = new Proyek();
        proyek.setNamaProyek(request.getNamaProyek());
        proyek.setClient(request.getClient());
        proyek.setTglMulai(request.getTglMulai());
        proyek.setTglSelesai(request.getTglSelesai());
        proyek.setPimpinanProyek(request.getPimpinanProyek());
        proyek.setKeterangan(request.getKeterangan());
        proyek.setCreatedAt(LocalDateTime.now());

        if (request.getLokasiIds() != null && !request.getLokasiIds().isEmpty()) {
            List<Lokasi> lokasiList = lokasiRepository.findAllById(request.getLokasiIds());
            Set<Lokasi> lokasiSet = new HashSet<>(lokasiList);
            proyek.setLokasi(lokasiSet);
        }

        proyek = proyekRepository.save(proyek);

        return new ProyekResponse(
                proyek.getId(),
                proyek.getNamaProyek(),
                proyek.getClient(),
                proyek.getTglMulai(),
                proyek.getTglSelesai(),
                proyek.getPimpinanProyek(),
                proyek.getKeterangan(),
                proyek.getCreatedAt(),
                proyek.getLokasi() != null ? proyek.getLokasi().stream().map(this::convertToLokasiResponse).collect(Collectors.toList()) : null
        );
    }

    @Override
    public ProyekResponse update(UpdateProyekRequest request) {
        Proyek proyek = proyekRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyek with ID " + request.getId() + " not found"));

        proyek.setNamaProyek(request.getNamaProyek());
        proyek.setClient(request.getClient());
        proyek.setTglMulai(request.getTglMulai());
        proyek.setTglSelesai(request.getTglSelesai());
        proyek.setPimpinanProyek(request.getPimpinanProyek());
        proyek.setKeterangan(request.getKeterangan());

        if (request.getLokasiIds() != null && !request.getLokasiIds().isEmpty()) {
            List<Lokasi> lokasiList = lokasiRepository.findAllById(request.getLokasiIds());
            Set<Lokasi> lokasiSet = new HashSet<>(lokasiList);
            proyek.setLokasi(lokasiSet);
        }

        proyek = proyekRepository.save(proyek);

        return new ProyekResponse(
                proyek.getId(),
                proyek.getNamaProyek(),
                proyek.getClient(),
                proyek.getTglMulai(),
                proyek.getTglSelesai(),
                proyek.getPimpinanProyek(),
                proyek.getKeterangan(),
                proyek.getCreatedAt(),
                proyek.getLokasi() != null ? proyek.getLokasi().stream().map(this::convertToLokasiResponse).collect(Collectors.toList()) : null
        );
    }

    @Override
    public void remove(Long id) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyek with ID " + id + " not found"));

        proyekRepository.delete(proyek);
    }

    private LokasiResponse convertToLokasiResponse(Lokasi lokasi) {
        return new LokasiResponse(
                lokasi.getId(),
                lokasi.getNamaLokasi(),
                lokasi.getNegara(),
                lokasi.getProvinsi(),
                lokasi.getKota(),
                lokasi.getCreatedAt()
        );
    }
}