package com.makerpanda.MixlyContest.service.manageservice;

import com.makerpanda.MixlyContest.dao.ManagerDAO;
import org.springframework.stereotype.Service;

@Service
public class ManageLoginService {
    //匹配成功返回true，否则返回false
    public static boolean verify(String ManagerID,String Password) {
        ManagerDAO managerdao = new ManagerDAO();
        String managerpassword=managerdao.getPassword(ManagerID);
        return Password.equals(managerpassword);
    }
}
