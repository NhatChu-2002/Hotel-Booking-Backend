package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.entity.*;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class HotelSpecifications {
    public static Specification<Hotel> withSmallFilters( FilterSearchRequest filters) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("status"), HotelStatus.ACTIVE));
            if (filters.getRate() != null && !filters.getRate().isEmpty()) {
                Join<Hotel, HotelRate> hotelRateJoin = root.join("hotelRate");
                predicates.add(criteriaBuilder.equal(hotelRateJoin.get("name"), filters.getRate()));
            }

            if (filters.getFromPrice() != null && filters.getToPrice() != null) {
                Join<Hotel, RoomType> roomTypeJoin = root.join("roomTypes");
                predicates.add(criteriaBuilder.between(roomTypeJoin.get("price"), filters.getFromPrice(), filters.getToPrice()));

            }

            if (filters.getReview() != null) {
                Subquery<Double> subquery = query.subquery(Double.class);
                Root<Review> subRoot = subquery.from(Review.class);
                subquery.select(criteriaBuilder.avg(subRoot.get("ratingTotal")))
                        .where(criteriaBuilder.equal(subRoot.get("hotel"), root));
                subquery.groupBy(subRoot.get("hotel"));

                Expression<Double> avgRating = subquery.getSelection();
                predicates.add(criteriaBuilder.ge(avgRating, filters.getReview()));

            }


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
    public static Specification<Hotel> withFilters(CustomSearchResult customSearchResult, FilterSearchRequest filters) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            List<HotelFilterSearchResult> hotels = customSearchResult.getHotels();

            if (hotels == null) {
                throw new ResponseException("No hotel found!");
            }

            List<Integer> hotelIds = hotels.stream()
                    .map(HotelFilterSearchResult::getId)
                    .collect(Collectors.toList());
            if (hotelIds != null && !hotelIds.isEmpty()) {
                predicates.add(root.get("id").in(hotelIds));
            }

            predicates.add(criteriaBuilder.equal(root.get("status"), HotelStatus.ACTIVE));

            if (filters.getRate() != null && !filters.getRate().isEmpty()) {
                Join<Hotel, HotelRate> hotelRateJoin = root.join("hotelRate");
                predicates.add(criteriaBuilder.equal(hotelRateJoin.get("name"), filters.getRate()));
            }

            if (filters.getFromPrice() != null && filters.getToPrice() != null) {
                Join<Hotel, RoomType> roomTypeJoin = root.join("roomTypes");
                predicates.add(criteriaBuilder.between(roomTypeJoin.get("price"), filters.getFromPrice(), filters.getToPrice()));

            }

            if (filters.getReview() != null) {
                Subquery<Double> subquery = query.subquery(Double.class);
                Root<Review> subRoot = subquery.from(Review.class);
                subquery.select(criteriaBuilder.avg(subRoot.get("ratingTotal")))
                        .where(criteriaBuilder.equal(subRoot.get("hotel"), root));
                subquery.groupBy(subRoot.get("hotel"));

                Expression<Double> avgRating = subquery.getSelection();
                predicates.add(criteriaBuilder.ge(avgRating, filters.getReview()));

            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
