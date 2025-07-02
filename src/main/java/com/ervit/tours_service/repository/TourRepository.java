package com.ervit.tours_service.repository;

import com.ervit.tours_service.model.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TourRepository extends MongoRepository<Tour, String> {
}
