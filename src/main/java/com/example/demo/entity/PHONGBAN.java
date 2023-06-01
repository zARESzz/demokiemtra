package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "PHONGBAN")
public class PHONGBAN {
    @Id
    @Column(name = "ma_phong")
    @NotEmpty(message = "Ma phong khong duoc rong")
    @Size(max = 2, min = 1, message = "Ma phong co 2 ky tu")
    private String ma_phong;
    @Column(name = "ten_phong")
    @NotEmpty(message = "Ten phong khong duoc rong")
    @Size(max = 30, min = 1, message = "Ten phong co it hon 30 ky tu")
    private String ten_phong;
    @OneToMany(mappedBy = "PHONGBAN",cascade = CascadeType.ALL)
    private List<NHANVIEN> NHANVIENS;
}
