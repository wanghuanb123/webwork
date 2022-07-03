package com.user.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer userId;
    private String userName;
    private String userAccount;
    private String userpassword;
    private String userAddress;
    private String userTel;
    private UType userType;
}
