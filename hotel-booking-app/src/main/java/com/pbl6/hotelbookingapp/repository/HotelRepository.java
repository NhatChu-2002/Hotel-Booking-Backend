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
    List<Hotel> findByProvince(String province);
    Optional<Hotel> findFirstById(Integer id);
    @Query("SELECT NEW com.pbl6.hotelbookingapp.dto.HotelWithTopRating(MIN(hi.imagePath), h.name, CONCAT(h.province, ', ', h.district, ', ', h.ward), AVG(r.ratingTotal), count(r)) " +
            "FROM Hotel h " +
            "JOIN HotelImage hi ON h.id = hi.hotel.id " +
            "LEFT JOIN Review r ON h.id = r.hotel.id " +
            "GROUP BY h.id, h.name, h.province, h.district, h.ward " +
            "ORDER BY AVG(r.ratingTotal) DESC " +
            "LIMIT 4")
    Set<HotelWithTopRating> getTop4HotelsWithFirstImage();

//    @Query("SELECT h FROM Hotel h " +
//            "JOIN h.roomTypes rt " +
//            "JOIN rt.rooms r " +
//            "JOIN r.roomReserved rr " +
//            "WHERE (rr.startDay >= :checkOutDay OR rr.endDay <= :checkInDay) " +
//            "OR NOT EXISTS ( " +
//            "    SELECT 1 " +
//            "    FROM RoomReserved rr2 " +
//            "    JOIN rr2.room r2 " +
//            "    WHERE (r2.id = r.id) " +
//            "    AND (:checkInDate BETWEEN rr2.startDay AND rr2.endDay " +
//            "        OR :checkOutDate BETWEEN rr2.startDay AND rr2.endDay) " +
//            ")")
//    List<Hotel> searchHotelsWithDate(@Param("checkInDate") LocalDate checkInDate, @Param("checkOutDate") LocalDate checkOutDate);
//    List<Hotel> searchHotelsWithGuestCount(@Param("checkInDate") LocalDate checkInDate, @Param("checkOutDate") LocalDate checkOutDate);
    @Query(name = "searchHotels", nativeQuery = true)
    List<HotelSearchResult> searchHotels(
            @Param("province") String province,
            @Param("checkin_day") LocalDate checkinDay,
            @Param("checkout_day") LocalDate checkoutDay,
            @Param("count") int count,
            @Param("adult_count") int adultCount,
            @Param("children_count") int childrenCount
    );
}
