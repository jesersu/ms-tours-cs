package com.ervit.tours_service.controller;

import com.ervit.tours_service.dto.TourRequest;
import com.ervit.tours_service.dto.TourResponse;
import com.ervit.tours_service.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody TourRequest tourRequest){
        tourService.createTour(tourRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TourResponse> getAllTours(){
        return tourService.getAlltours();
    }
}
