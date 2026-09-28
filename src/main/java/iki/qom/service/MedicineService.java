package iki.qom.service;

import iki.qom.dto.MedicineDto;

import java.util.List;

public interface MedicineService {
    MedicineDto createMedicine(MedicineDto medicineDto);
    List<MedicineDto> getAllMedicines();
    MedicineDto findMedicineById(Long medicineId);
    void deleteMedicine(Long medicineId);
}
