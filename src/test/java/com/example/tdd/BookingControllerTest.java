package com.example.tdd;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repository.BookingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.print.Book;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingTestGetAll() throws Exception {
        mockMvc.perform(get("/bookings"))
                .andExpect(status().isOk());
    }

    @Test
    public void bookingTestSave() throws Exception {
        BookingModel bookingModel = bookingModel();

        mockMvc.perform(post("/bookings")
                        .contentType("applications/json")
                        .content(objectMapper.writeValueAsString(bookingModel)))
                .andExpect(status().isCreated());

    }

    @Test
    public void bookingTestDelete() throws Exception {
        BookingModel bookingModel = bookingModel();

        mockMvc.perform(delete("/bookings/1")
                .contentType("applications/json")
                .content(objectMapper.writeValueAsString(bookingModel)))
                .andExpect(status().isNoContent());
    }

    @Test
    public void bookingTestUpdate() throws Exception {
        BookingModel bookingModel = bookingModel();

        mockMvc.perform(put("/bookings/1")
                        .contentType("applications/json")
                        .content(objectMapper.writeValueAsString(bookingModel)))
                .andExpect(status().isOk());

    }

    private static BookingModel bookingModel() {
        LocalDate checkIn = LocalDate.parse("2020-11-10");
        LocalDate checkOut = LocalDate.parse("2020-11-20");

        BookingModel bookingModel = new BookingModel(1, "Rayana", checkIn, checkOut, 2);

        return bookingModel;
    }

}
