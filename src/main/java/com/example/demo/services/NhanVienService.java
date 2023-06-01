package com.example.demo.services;

import com.example.demo.entity.NHANVIEN;
import com.example.demo.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanvienRepository;
    public List<NHANVIEN> getAllNhanviens(){
        return nhanvienRepository.findAll();
    }
    public NHANVIEN getNhanvienId(String id){
        return nhanvienRepository.findById(id).orElse(null);
    }
    public void addNhanvien(NHANVIEN NHANVIEN){
        nhanvienRepository.save(NHANVIEN);
    }
    public void deleteNhanvien(String id){
        nhanvienRepository.deleteById(id);
    }
    public void updateNhanvien(NHANVIEN NHANVIEN){
        nhanvienRepository.save(NHANVIEN);
    }

}
