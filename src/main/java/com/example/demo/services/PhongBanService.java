package com.example.demo.services;

import com.example.demo.entity.PHONGBAN;
import com.example.demo.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongbanRepository;
    public List<PHONGBAN> getAllPhongban(){ return phongbanRepository.findAll();}
    public PHONGBAN getPhongbanById(String id){return phongbanRepository.findById(id).orElse(null);}
    public PHONGBAN savePhongban(PHONGBAN PHONGBAN) { return phongbanRepository.save(PHONGBAN);}
    public void deletePhongban(String id){ phongbanRepository.deleteById(id);}
}
