package com.company.view;

import com.company.domain.Business;

public interface BusinessView {
    public void listAllBusinesses();
    public void selectBusinesses();
    public void saveBusiness();
    public void removeBusiness();

    public Business login();

    public void updatePassword(Integer businessId);
}
