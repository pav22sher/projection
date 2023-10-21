package com.example.projection.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ManView {
    Long getId();
    String getLastName();
    AddressView getAddress();
    interface AddressView {
        String getCity();
        String getStreet();
    }
    @Value("#{target.firstName + '-' + target.lastName + '-' + target.address.city + '-' + target.address.street}")
    String getFullInfo();
}
