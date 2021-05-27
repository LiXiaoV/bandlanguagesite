package com.bandlanguage.bandlanguagesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan(basePackages = "com.bandlanguage.bandlanguagesite.filter")
public class BandlanguagesiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(BandlanguagesiteApplication.class, args);
    }

}
