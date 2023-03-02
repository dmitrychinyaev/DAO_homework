package com.example.dao_homework.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {
    private static final String requestSql = "request.sql";
    private String requestScript;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public Repository() {
        this.requestScript = read(requestSql);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name){
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", name);
        return namedParameterJdbcTemplate.queryForList(requestScript, params, String.class);
    }
}
