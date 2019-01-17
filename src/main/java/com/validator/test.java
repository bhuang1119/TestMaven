package com.validator;

import com.testProxy.ProxyInterface;

import javax.validation.*;
import java.util.Set;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in
 * @Modified By:
 */
public class test {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Person person = new Person("",-1);
//        Set<ConstraintViolation<Person>>  constraintViolations = validator.validate(person);
//        Set<ConstraintViolation<Person>>  constraintViolations = validator.validateProperty(person,"name");
//        Set<ConstraintViolation<Person>>  constraintViolations = validator.validateValue(Person.class,"name",null);
//        Set<ConstraintViolation<Person>>  constraintViolations = validator.validateValue(Person.class,"group","111111",ProxyInterface.class);
        Set<ConstraintViolation<Person>> constraintViolations = validator.validateValue(Person.class, "gender", GenderType.Woman);
        System.out.println(constraintViolations.toString());
    }
}
