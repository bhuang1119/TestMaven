package com.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in
 * @Modified By:
 */
public class GenderTypeValidator implements ConstraintValidator<GenderCase,GenderType> {
    GenderType value;

    @Override
    public void initialize(GenderCase genderCase) {
        value = genderCase.value();
    }

    @Override
    public boolean isValid(GenderType genderType, ConstraintValidatorContext constraintValidatorContext) {
        if(value!=null&&genderType!=null&&value!=genderType){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("gender should be " + value + "| the value is " + genderType).addConstraintViolation();
            return false;
        }else{
            return true;
        }
    }
}
