package co.develhope.customqueries2.repositories;

import co.develhope.customqueries2.entities.Flight;
import co.develhope.customqueries2.entities.FlightStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.status = :status")
    Page<Flight> findAllByStatus(@Param("status") FlightStatus status,Pageable pageable);

    @Query("SELECT f FROM Flight f WHERE f.status = ?1 OR f.status = ?2")
    List<Flight> getCustomFlight(@Param("status1") FlightStatus status1,
                                 @Param("status2") FlightStatus status2);

}
