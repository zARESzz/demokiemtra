package com.example.demo.validator;

import com.example.demo.entity.PHONGBAN;
import com.example.demo.validator.annotation.ValidPhongBanId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhongBanIdValidator implements ConstraintValidator<ValidPhongBanId, PHONGBAN> {
    @Override
    public boolean isValid(PHONGBAN PHONGBAN, ConstraintValidatorContext context){
        return PHONGBAN !=null && PHONGBAN.getMa_phong()!=null;
    }
}
