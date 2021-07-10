package com.example.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Demo {
    @Value("${test}")
    private Integer test;
}
