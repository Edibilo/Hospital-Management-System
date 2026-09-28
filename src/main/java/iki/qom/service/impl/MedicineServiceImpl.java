package iki.qom.service.impl;

import iki.qom.dto.MedicineDto;
import iki.qom.entity.Medicine;
import iki.qom.mapper.MedicineMapper;
import iki.qom.repository.MedicineRepository;
import iki.qom.service.MedicineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public MedicineDto createMedicine(MedicineDto medicineDto) {
        Medicine medicine= MedicineMapper.mapToMedicine(medicineDto);
        Medicine savedMedicine=medicineRepository.save(medicine);
        return MedicineMapper.mapToMedicineDto(savedMedicine);
    }

    @Override
    public List<MedicineDto> getAllMedicines() {
        List<Medicine> medicines=medicineRepository.findAll();
        return medicines.stream().map(MedicineMapper::mapToMedicineDto).collect(Collectors.toList());
    }

    @Override
    public MedicineDto findMedicineById(Long medicineId) {
        Medicine medicine=medicineRepository.findById(medicineId).orElseThrow(
                () -> new RuntimeException("Medicine Not Found !")
        );
        return MedicineMapper.mapToMedicineDto(medicine);
    }

    @Override
    public void deleteMedicine(Long medicineId) {
        Medicine medicine=medicineRepository.findById(medicineId).orElseThrow(
                () -> new RuntimeException("Medicine Not Found !")
        );
        medicineRepository.delete(medicine);
    }
}
