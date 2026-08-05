package com.convio.backend.IntegrationTests;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Import;


import com.convio.backend.jdbc.JdbcUserRepository;


@JdbcTest
@Import(JdbcUserRepository.class)
public class JdbcUserRepositoryTest {

    @Autowired
    private JdbcUserRepository repository;

    @Test 
    

}
