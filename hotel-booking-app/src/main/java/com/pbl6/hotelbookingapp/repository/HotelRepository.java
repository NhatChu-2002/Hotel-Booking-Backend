package com.pbl6.hotelbookingapp.repository;


import com.pbl6.hotelbookingapp.dto.*;
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
    List<HotelSearchResult>  searchHotels(
            @Param("province") String province,
            @Param("checkin_day") LocalDate checkinDay,
            @Param("checkout_day") LocalDate checkoutDay,
            @Param("count") int count,
            @Param("adult_count") int adultCount,
            @Param("children_count") int childrenCount
    );

    Optional<Hotel> findByUserIdAndId(Integer userId, Integer hotelId);
    List<Hotel> findAllByUserId(Integer hostId);

    @Query("SELECT NEW com.pbl6.hotelbookingapp.dto.RevenueResponse(" +
            "MONTH(rs.createdAt), " +
            "SUM(rs.totalPrice * 0.8)" +
            ") " +
            "FROM RoomReserved rr " +
            "JOIN Reservation rs ON rr.reservation.id = rs.id " +
            "JOIN Room r ON r.id = rr.room.id " +
            "JOIN RoomType rt ON r.roomType.id = rt.id " +
            "JOIN Hotel h ON rt.hotel.id = h.id " +
            "WHERE h.id = :hotelId " +
            "AND YEAR(rs.createdAt) = :year " +
            "AND rs.status = 'CONFIRMED' " +
            "GROUP BY MONTH(rs.createdAt) " +
            "ORDER BY MONTH(rs.createdAt)")
    List<RevenueResponse> getRevenueByYear(@Param("hotelId") Integer hotelId, @Param("year") Integer year);


    @Query("SELECT NEW com.pbl6.hotelbookingapp.dto.RevenueResponse(" +
            "MONTH(r.createdAt), " +
            "SUM(r.siteFee + r.taxPaid)" +
            ") " +
            "FROM Reservation r " +
            "WHERE YEAR(r.createdAt) = :year " +
            "AND r.status = 'CONFIRMED' " +
            "GROUP BY MONTH(r.createdAt) " +
            "ORDER BY MONTH(r.createdAt)")
    List<RevenueResponse> getRevenueForAdminByYear(@Param("year") Integer year);

    @Query("SELECT NEW com.pbl6.hotelbookingapp.dto.RevenueByYearResponse(" +
            "YEAR(r.createdAt), " +
            "SUM(r.siteFee + r.taxPaid)" +
            ") " +
            "FROM Reservation r " +
            "WHERE r.status = 'CONFIRMED' " +
            "GROUP BY YEAR(r.createdAt) " +
            "ORDER BY YEAR(r.createdAt)")
    List<RevenueByYearResponse> getRevenueForAdmin();
}
