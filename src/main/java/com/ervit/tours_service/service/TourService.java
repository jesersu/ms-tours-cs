package com.ervit.tours_service.service;

import com.ervit.tours_service.dto.TourRequest;
import com.ervit.tours_service.dto.TourResponse;
import com.ervit.tours_service.model.Tour;
import com.ervit.tours_service.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TourService {

    private final TourRepository tourRepository;

    public void createTour(TourRequest tourRequest) {
        Tour tour = Tour.builder()
                .name(tourRequest.getName())
                .description(tourRequest.getDescription())
                .price(tourRequest.getPrice())
                .build();

        tourRepository.save(tour);
        log.info("Product {} is saved", tour.getId());
    }


    public List<TourResponse> getAlltours() {
        List<Tour> products = tourRepository.findAll();
        return products.stream().map(this::mapToTourResponse).toList();
    }

    private TourResponse mapToTourResponse(Tour tour) {
        return TourResponse.builder()
                .id(tour.getId())
                .name(tour.getName())
                .description(tour.getDescription())
                .price(tour.getPrice())
                .build();
    }
}
