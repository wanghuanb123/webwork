package com.admin.test;

import com.admin.entity.GType;
import com.admin.service.GTypeService;

import java.util.List;

public class gTypeTest {
    public static void main(String[] args) {
        GTypeService gTypeService = new GTypeService();
        List<GType> gTypes = gTypeService.selectAllGType();
        for(int i=0;i<gTypes.size();i++){
            System.out.println(gTypes.get(i));
        }
    }
}
