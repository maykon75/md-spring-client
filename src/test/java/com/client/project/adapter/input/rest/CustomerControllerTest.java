package com.client.project.adapter.input.rest;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    static MockWebServer mockWebServer;

    @BeforeAll
    static void startMockServer() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start(8080);
    }

    @AfterAll
    static void shutdownMockServer() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void getCustomerSuccess() throws Exception {
        ClassPathResource resource = new ClassPathResource("test/getCustomerSuccess.json");
        String mockResponseBody = Files.readString(Path.of(resource.getURI()));

        mockWebServer.enqueue(new MockResponse()
                .setBody(mockResponseBody)
                .addHeader("Content-Type", "application/json"));

        mockMvc.perform(get("/api/client/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(mockResponseBody));
    }

    @Test
    void getAllCustomerSuccess() throws Exception {
        ClassPathResource resource = new ClassPathResource("test/getAllCustomerSuccess.json");
        String mockResponseBody = Files.readString(Path.of(resource.getURI()));

        mockWebServer.enqueue(new MockResponse()
                .setBody(mockResponseBody)
                .addHeader("Content-Type", "application/json"));

        mockMvc.perform(get("/api/client"))
                .andExpect(status().isOk())
                .andExpect(content().json(mockResponseBody));
    }

    @Test
    void postRequestValid() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(201)
                .setBody("")
                .addHeader("Content-Type", "application/json"));

        ClassPathResource resource = new ClassPathResource("test/customerSuccess.json");
        String requestBody = Files.readString(Path.of(resource.getURI()));

        mockMvc.perform(post("/api/client")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldUpdateCustomer() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(204)
                .setBody("")
                .addHeader("Content-Type", "application/json"));

        ClassPathResource resource = new ClassPathResource("test/customerSuccess.json");
        String updateBody = Files.readString(Path.of(resource.getURI()));

        mockMvc.perform(put("/api/client/1")
                        .contentType("application/json")
                        .content(updateBody))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldDeleteCustomer() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(204)
                .setBody("")
                .addHeader("Content-Type", "application/json"));

        mockMvc.perform(delete("/api/client/1"))
                .andExpect(status().isNoContent());

    }

}