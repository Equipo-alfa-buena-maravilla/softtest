package com.softtek.softtest;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 *
 * */
public class CSVUserRepository implements UserRepository {
    private static final String USERS_FILE_PATH = "registered_users.csv";
    private final CSVReader csvReader;
    private CsvToBeanBuilder<CSVUser> builder;


    public CSVUserRepository() {
        try {
            var resource = getClass().getClassLoader().getResource(USERS_FILE_PATH);
            Objects.requireNonNull(resource);
            var reader = Files.newBufferedReader(Paths.get(resource.toURI()));
            this.builder = new CsvToBeanBuilder<>(reader);
//            Skip line avoids serializing the header
            this.csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Unexpected URI syntax or file not found.");
        }
    }


    @Override
    public List<? extends User> findAll() {
        return getUsers();
    }

    private List<? extends User> getUsers() {
        return builder
                .withType(CSVUser.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .stream()
                .toList();
    }

    @Override
    public User getRandomUser() {
        var users = getUsers();
        final var random = new Random();
        return users.get(random.nextInt(users.size()));
    }


}
