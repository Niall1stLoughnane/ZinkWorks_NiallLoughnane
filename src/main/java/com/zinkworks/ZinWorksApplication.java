/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class is the main Spring Boot method to run the ATM system application
 **/

package com.zinkworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZinWorksApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZinWorksApplication.class, args);
    }

}
