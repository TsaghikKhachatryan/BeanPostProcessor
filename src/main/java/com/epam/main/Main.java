package com.epam.main;

import com.epam.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annoBean= new AnnotationConfigApplicationContext() ;
        annoBean.scan("com.epam");
        annoBean.refresh();
        System.out.println(annoBean.getBean(Employee.class));

        System.out.println("bsv b");
    }
}
