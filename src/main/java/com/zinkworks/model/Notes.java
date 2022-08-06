package com.zinkworks.model;

import lombok.Data;

@Data
public class Notes {

    private int quantity50;
    private int quantity20;
    private int quantity10;
    private int quantity5;
    private double value;

    public void initiailze() {
        this.quantity50 = 10;
        this.quantity20 = 30;
        this.quantity10 = 30;
        this.quantity5 = 20;
    }

}
