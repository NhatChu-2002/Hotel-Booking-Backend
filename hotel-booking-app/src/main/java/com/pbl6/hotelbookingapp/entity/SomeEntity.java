package com.pbl6.hotelbookingapp.entity;
import com.pbl6.hotelbookingapp.dto.HotelSearchResult;
import jakarta.persistence.*;
;
@Entity
@NamedNativeQuery(
        name = "searchHotels",
        query = "SELECT " +
                "h.id AS hotelId, "+
                "h.name AS hotelName, " +
                "CONCAT(h.province, ', ', h.district, ', ', h.ward) AS address, " +
                "MIN(IFNULL(hi.image_path, '')) AS hotelImgPath, " +
                "GROUP_CONCAT(DISTINCT ha.name) AS amenity, " +
                "ROUND(COALESCE(AVG(r.rating_total), 0), 2) AS ratingTotal, " +
                "COUNT(DISTINCT r.id) AS reviews, " +
                "MIN(rt.price) AS minPrice, " +
                "MAX(rt.price) AS maxPrice " +
                "FROM hotel h " +
                "LEFT JOIN hotel_image hi ON h.id = hi.hotel_id " +
                "LEFT JOIN ( " +
                "    SELECT hha.hotel_id, GROUP_CONCAT(ha.name) AS name " +
                "    FROM hotel_hotel_amenity hha " +
                "    JOIN hotel_amenity ha ON hha.hotel_amenity_id = ha.id " +
                "    GROUP BY hha.hotel_id " +
                ") ha ON h.id = ha.hotel_id " +
                "LEFT JOIN review r ON h.id = r.hotel_id " +
                "LEFT JOIN room_type rt ON h.id = rt.hotel_id " +
                "LEFT JOIN room ro ON rt.id = ro.room_type_id " +
                "LEFT JOIN room_reserved rr ON ro.id = rr.room_id " +
                "WHERE LOWER(REPLACE(h.province, ' ', '')) = LOWER(REPLACE(:province, ' ', '')) " +
                "AND rt.count >= :count " +
                "AND (rt.count - COALESCE(( " +
                "    SELECT SUM(IF(:checkin_day BETWEEN rr2.start_day AND rr2.end_day OR :checkout_day BETWEEN rr2.start_day AND rr2.end_day, 1, 0)) " +
                "    FROM room_reserved rr2 " +
                "    JOIN room ro2 ON rr2.room_id = ro2.id " +
                "    JOIN room_type rt2 ON ro2.room_type_id = rt2.id " +
                "    WHERE (rt2.hotel_id = h.id AND rt2.id = rt.id) " +
                "), 0)) >= :count " +
                "AND rt.adult_count >= :adult_count " +
                "AND rt.children_count >= :children_count " +
                "GROUP BY h.id",
        resultSetMapping = "HotelSearchResultMapping"
)
@SqlResultSetMapping(
        name = "HotelSearchResultMapping",
        classes = @ConstructorResult(
                targetClass = HotelSearchResult.class,
                columns = {
                        @ColumnResult(name = "hotelId", type = Integer.class),
                        @ColumnResult(name = "hotelName", type = String.class),
                        @ColumnResult(name = "address", type = String.class),
                        @ColumnResult(name = "hotelImgPath", type = String.class),
                        @ColumnResult(name = "amenity", type = String.class),
                        @ColumnResult(name = "ratingTotal", type = Double.class),
                        @ColumnResult(name = "reviews", type = Long.class),
                        @ColumnResult(name = "minPrice", type = Double.class),
                        @ColumnResult(name = "maxPrice", type = Double.class)


                }
        )
)
public class SomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Các trường khác
}

