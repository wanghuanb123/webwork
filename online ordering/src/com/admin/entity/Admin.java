package com.admin.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {
    private Integer adminId;
    private String adminName;
    private String adminPassword;
    private GType adminType;

}
