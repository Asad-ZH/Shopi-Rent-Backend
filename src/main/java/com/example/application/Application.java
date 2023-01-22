package com.example.application;

import com.example.application.Entity.Buyer;
import com.example.application.Entity.Product;
import com.example.application.dao.BuyerRepository;
import com.example.application.dao.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(BuyerRepository buyerRepository, ProductRepository productRepository) {
        return args -> {
            Faker faker = new Faker();
            for (int i = 0; i < 5; i++) {
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String password = faker.name().lastName();
                String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);

                Buyer dummyBuyer = new Buyer(
                        firstName,
                        lastName,
                        email,
                        password,
                        faker.number().numberBetween(17, 55));
                buyerRepository.save(dummyBuyer);
            }

            for (int i = 0; i < 5; i++) {

                String title = faker.lorem().sentence();
                String lastName = faker.lorem().paragraph();
                String imageURL = faker.lorem().sentence();
                String category = faker.lorem().words().toString();
                String subCategory = faker.lorem().words().toString();
                List<String> colors = Arrays.asList(faker.color().name(),faker.color().name(),faker.color().name(),faker.color().name());
                List<String> size = Arrays.asList(faker.lorem().words().toString(),faker.lorem().words().toString(),faker.lorem().words().toString());
                String brand = faker.lorem().word();
                List<String> highlights = Arrays.asList(faker.lorem().word(),faker.lorem().sentence(),faker.lorem().sentence());
                String weather = faker.lorem().word();
                String sleeves = faker.lorem().word();
                String bodyType = faker.lorem().word();
                Integer securityDeposit = faker.number().numberBetween(10000, 20000);
                Integer rentPerDay = faker.number().numberBetween(10000, 20000);
                LocalDateTime pickUpDate = LocalDateTime.now();
                LocalDateTime returnDate = LocalDateTime.now().plusDays(5);
                Integer rentingPrice = faker.number().numberBetween(10000, 20000);
                Integer sellingPrice = faker.number().numberBetween(10000, 20000);
                Integer saleRentingPrice = faker.number().numberBetween(10000, 20000);
                Integer saleSellingPrice = faker.number().numberBetween(10000, 20000);


                Product dummyProduct = new Product(
                        title,
                        lastName,
                        imageURL,
                        category,
                        subCategory,
                        colors,
                        size,
                        brand,
                        highlights,
                        weather,
                        sleeves,
                        bodyType,
                        securityDeposit,
                        rentPerDay,
                        pickUpDate,
                        returnDate,
                        rentingPrice,
                        sellingPrice,
                        saleRentingPrice,
                        saleSellingPrice);

                productRepository.save(dummyProduct);
            }

//
//            student.addBook(
//                    new Book("Clean Code", LocalDateTime.now().minusDays(4)));
//
//
//            student.addBook(
//                    new Book("Think and Grow Rich", LocalDateTime.now()));
//
//
//            student.addBook(
//                    new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));
//
//            StudentIdCard studentIdCard = new StudentIdCard(
//                    faker.number().toString(),
//                    student);

//            student.enrolToCourse(
//                    new Course("ipdc","course1")
//            );
//            student.enrolToCourse(
//                    new Course("gd","course2")
//            );
//            student.enrolToCourse(
//                    new Course("mis","course3")
//            );

//            student.addEnrollment(new Enrolment(
//                    new EnrolmentId(142L, 1423L),
//                    student,
//                    new Course("Computer Science", "IT"),
//                    LocalDateTime.now()
//            ));
//
//            student.setStudentIdCard(studentIdCard);
//
//            studentRepository.save(student);
//
//            studentRepository.findById(2L)
//                    .ifPresent(s -> {
//                        System.out.println("fetch book lazy...");
//                        List<Book> books = student.getBooks();
//                        books.forEach(book -> {
//                            System.out.println(
//                                    s.getFirstName() + " borrowed " + book.getBookName());
//                        });
//                    });

        };
    }
}
