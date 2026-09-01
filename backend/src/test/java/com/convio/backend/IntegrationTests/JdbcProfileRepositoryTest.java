package com.convio.backend.IntegrationTests;

import java.util.List;
import java.util.UUID;

import com.convio.backend.jdbc.JdbcProfileRepository;
import com.convio.backend.jdbc.JdbcUserRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
@Import(JdbcProfileRepository.class)
public class JdbcProfileRepositoryTest {

}
