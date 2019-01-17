package com.validator;

import com.testProxy.ProxyInterface;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in
 * @Modified By:
 */
@Setter
@Getter
@AllArgsConstructor
public class Person {

    @NotBlank
    private String name;

    @Min(value = 0)
    private int age;

    @GenderCase
    private GenderType gender;

    @Size(min=1,max=5,groups = ProxyInterface.class)
    private String group;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
