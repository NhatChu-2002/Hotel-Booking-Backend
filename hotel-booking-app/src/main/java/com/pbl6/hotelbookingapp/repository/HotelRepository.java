package com.pbl6.hotelbookingapp.repository;


import com.pbl6.hotelbookingapp.dto.HotelFilterSearchResult;
import com.pbl6.hotelbookingapp.dto.HotelSearchResult;
import com.pbl6.hotelbookingapp.dto.HotelWithTopRating;
import com.pbl6.hotelbookingapp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface HotelRepository extends JpaRepository<Hotel, Integer>, JpaSpecificationExecutor<Hotel> {
    Optional<Hotel> findFirstByNameAndProvinceAndStreet(String name, String province, String street);
    Optional<Hotel> findFirstById(Integer id);
    Optional<Hotel> findByIdAndUserId(Integer hotelId, Integer userId);
    @Query("SELECT NEW com.pbl6.hotelbookingapp.dto.HotelWithTopRating(MIN(hi.imagePath), h.name, CONCAT(h.province, ', ', h.district, ', ', h.ward), AVG(r.ratingTotal), count(r)) " +
            "FROM Hotel h " +
            "JOIN HotelImage hi ON h.id = hi.hotel.id " +
            "LEFT JOIN Review r ON h.id = r.hotel.id " +
            "GROUP BY h.id, h.name, h.province, h.district, h.ward " +
            "ORDER BY AVG(r.ratingTotal) DESC " +
            "LIMIT 4")
    Set<HotelWithTopRating> getTop4HotelsWithFirstImage();


    @Query(name = "searchHotels", nativeQuery = true)
    List<HotelSearchResult> searchHotels(
            @Param("province") String province,
            @Param("checkin_day") LocalDate checkinDay,
            @Param("checkout_day") LocalDate checkoutDay,
            @Param("count") int count,
            @Param("adult_count") int adultCount,
            @Param("children_count") int childrenCount
    );

    Optional<Hotel> findByUserIdAndId(Integer userId, Integer hotelId);
    List<Hotel> findAllByUserId(Integer hostId);
}
