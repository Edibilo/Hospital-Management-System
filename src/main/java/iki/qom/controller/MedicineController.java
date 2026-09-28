package iki.qom.controller;

import iki.qom.dto.MedicineDto;
import iki.qom.service.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/medicines")
public class MedicineController {

    private final MedicineService medicineService;


    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public String getMedicine(Model model){
        model.addAttribute("medicine",new MedicineDto());
        model.addAttribute("medicines",medicineService.getAllMedicines());
        return "get-medicine";
    }

    @PostMapping
    public String creteMedicine(@ModelAttribute MedicineDto medicineDto){
        medicineService.createMedicine(medicineDto);
        return "redirect:/api/v1/medicines";
    }

    @GetMapping("{medicineId}/edit")
    public String editMedicine(@PathVariable Long medicineId, Model model){
        model.addAttribute("medicine",medicineService.findMedicineById(medicineId));
        model.addAttribute("medicines",medicineService.getAllMedicines());
        return "get-medicine";
    }

    @GetMapping("{medicineId}/delete")
    public String deleteMedicine(@PathVariable Long medicineId){
        medicineService.deleteMedicine(medicineId);
        return "redirect:/api/v1/medicines";
    }
}
