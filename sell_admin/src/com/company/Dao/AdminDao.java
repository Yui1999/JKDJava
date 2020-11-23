package com.company.Dao;

import com.company.domain.Admin;

public interface AdminDao {
    public Admin getAdminByNameAndPassword(String adminName, String Password);
}
