package iki.qom.mapper;

import iki.qom.dto.MedicineDto;
import iki.qom.entity.Medicine;

public class MedicineMapper {

    public static Medicine mapToMedicine(MedicineDto medicineDto){
        Medicine medicine=new Medicine();
        medicine.setId(medicineDto.getId());
        medicine.setName(medicineDto.getName());
        medicine.setStrength(medicineDto.getStrength());
        medicine.setUnitPrice(medicineDto.getUnitPrice());
        medicine.setQuantityInStock(medicineDto.getQuantityInStock());
        return medicine;
    }

    public static MedicineDto mapToMedicineDto(Medicine medicine){
        MedicineDto medicineDto=new MedicineDto();
        medicineDto.setId(medicine.getId());
        medicineDto.setName(medicine.getName());
        medicineDto.setStrength(medicine.getStrength());
        medicineDto.setUnitPrice(medicine.getUnitPrice());
        medicineDto.setQuantityInStock(medicine.getQuantityInStock());
        return medicineDto;
    }
}
