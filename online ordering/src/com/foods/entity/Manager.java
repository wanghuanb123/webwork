package com.foods.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Manager {
    private String managerId;
    private String managerAccount;
    private String managerPassword;
    private String managerName;
}
