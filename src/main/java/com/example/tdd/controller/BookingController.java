package com.example.tdd.controller;

import com.example.tdd.model.BookingModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @GetMapping
    @ResponseBody
    public String getAll() throws Exception{
        return "OK";
    }

    @PostMapping
    public ResponseEntity<BookingModel> save(BookingModel bookingModel){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookingModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookingModel> delete(BookingModel bookingModel) {
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingModel> update(BookingModel bookingModel) {
        return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
    }

}
