package com.example.projection;

import com.example.projection.dao.ManRepository;
import com.example.projection.model.Address;
import com.example.projection.model.Man;
import com.example.projection.projection.ManDTO;
import com.example.projection.projection.ManView;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProjectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectionApplication.class, args);
    }

    @Autowired
    private ManRepository manRepository;


    @PostConstruct
    private void init() {
        //initDb();
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
    }

    private void initDb() {
        manRepository.deleteAll();
        List<Man> mans = new ArrayList<>();

        Man man1 = new Man();
        man1.setFirstName("FirstName1");
        man1.setLastName("LastName1");
        Address address1 = new Address();
        address1.setCity("City1");
        address1.setStreet("Street1");
        man1.setAddress(address1);
        mans.add(man1);

        Man man2 = new Man();
        man2.setFirstName("FirstName2");
        man2.setLastName("LastName2");
        Address address2 = new Address();
        address2.setCity("City2");
        address2.setStreet("Street2");
        man2.setAddress(address2);
        mans.add(man2);

        manRepository.saveAllAndFlush(mans);
    }
    private void test1() {
        List<Object[]> results = manRepository.getIdAndLastname1();
        for(var result: results) {
            System.out.println("id: " + result[0]);
            System.out.println("lastname: " + result[1]);
        }
    }
    private void test2() {
        List<Tuple> results = manRepository.getIdAndLastname2();
        for(var result: results) {
            System.out.println("id: " + result.get("id"));
            System.out.println("lastname: " + result.get("lastname"));
        }
    }
    private void test3() {
        List<ManDTO> results = manRepository.getIdAndLastname3();
        for(var result: results) {
            System.out.println("id: " + result.getId());
            System.out.println("lastname: " + result.getLastName());
        }
    }
    private void test4() {
        List<ManDTO> results = manRepository.findAllByFirstName("FirstName1");
        for(var result: results) {
            System.out.println("id: " + result.getId());
            System.out.println("lastname: " + result.getLastName());
        }
    }
    private void test5() {
        List<ManView> results = manRepository.findAllByLastName("LastName1");
        for(var result: results) {
            System.out.println("id: " + result.getId());
            System.out.println("lastname: " + result.getLastName());
            System.out.println("city: " + result.getAddress().getCity());
            System.out.println("street: " + result.getAddress().getStreet());
            System.out.println("fullInfo: " + result.getFullInfo());
        }
    }
    private void test6() {
        List<ManDTO> results = manRepository.findAllByFirstName("FirstName1", ManDTO.class);
        for(var result: results) {
            System.out.println("id: " + result.getId());
            System.out.println("lastname: " + result.getLastName());
        }
    }
}
