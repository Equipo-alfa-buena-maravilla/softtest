package com.softtek.softtest;


import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CSVUser implements User {

    @CsvBindByName(column = "username")
    private String username;

    @CsvBindByName(column = "password")
    private String password;

    @Override
    public boolean isActive() {
        return true;
    }
}
