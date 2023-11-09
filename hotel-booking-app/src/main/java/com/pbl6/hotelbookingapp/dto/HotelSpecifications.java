package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.HotelRate;
import com.pbl6.hotelbookingapp.entity.Review;
import com.pbl6.hotelbookingapp.entity.RoomType;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class HotelSpecifications {

    public static Specification<Hotel> withFilters(FilterSearchRequest filters) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filters.getHotelIds() != null && !filters.getHotelIds().isEmpty()) {
                predicates.add(root.get("id").in(filters.getHotelIds()));
            }

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
