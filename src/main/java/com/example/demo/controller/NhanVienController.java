package com.example.demo.controller;

import com.example.demo.entity.NHANVIEN;
import com.example.demo.services.NhanVienService;
import com.example.demo.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String showAllNhanVien(Model model){
        List<NHANVIEN> NHANVIENS = nhanVienService.getAllNhanviens();
        model.addAttribute("nhanviens", NHANVIENS);
        return "nhanvien/list";
    }
    @GetMapping("/add")
    public String addNhanVienForm(Model model){
        model.addAttribute("nhanvien",new NHANVIEN());
        model.addAttribute("PHONGBANs", phongBanService.getAllPhongban());
        return "nhanvien/add";
    }
    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien") NHANVIEN NHANVIEN, BindingResult result, Model model){
        // check lỗi
        if(result.hasErrors()){
            model.addAttribute("phongbans", phongBanService.getAllPhongban());
            return "nhanvien/add";
        }
        nhanVienService.addNhanvien(NHANVIEN);
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{ma_nv}")
    public String deleteNhanvien(@PathVariable("ma_nv") String ma_nv){
        nhanVienService.deleteNhanvien(ma_nv);
        return "redirect:/nhanviens";
    }
    @GetMapping("edit/{ma_nv}")
    public String editNhanVienForm(@PathVariable("ma_nv")String ma_nv, Model model){
        NHANVIEN editnhanvien = nhanVienService.getNhanvienId(ma_nv);
        if (editnhanvien != null ){
            model.addAttribute("nhanvien",editnhanvien);
            model.addAttribute("PHONGBANs", phongBanService.getAllPhongban());
            return "nhanvien/edit";
        }else {
            return "redirect:/nhanviens";
        }
    }

    @PostMapping("edit/{ma_nv}")
    public String editNhanVien(@PathVariable("ma_nv")String ma_nv, @ModelAttribute("nhanvien") @Valid NHANVIEN editNHANVIEN, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("PHONGBANs", phongBanService.getAllPhongban());
            return "nhanvien/edit";
        }else {
            NHANVIEN existingNHANVIEN = nhanVienService.getNhanvienId(ma_nv);
            if ( existingNHANVIEN != null){
                existingNHANVIEN.setLuong(editNHANVIEN.getLuong());
                existingNHANVIEN.setNoi_sinh(editNHANVIEN.getNoi_sinh());
                existingNHANVIEN.setPhai(editNHANVIEN.getPhai());
                existingNHANVIEN.setTen_nv(editNHANVIEN.getTen_nv());
                existingNHANVIEN.setPHONGBAN((editNHANVIEN.getPHONGBAN()));
                nhanVienService.updateNhanvien(existingNHANVIEN);
            }
            return "redirect:/nhanviens";
        }
    }

}
