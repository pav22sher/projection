package com.example.projection.projection;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ManProjection {
    String firstName;

    public ManProjection(String firstName) {
        this.firstName = firstName;
    }
}
