package com.library1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("Starting LibraryManagementApplication...");

        // Load the Spring context from the XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Step 1: Spring context loaded from applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Call a method to trigger the aspect
        bookService.performService();

        System.out.println("LibraryManagementApplication execution completed.");
    }
}
