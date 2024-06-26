package com.example.security20.repository;

import com.example.security20.entity.ReportOfWorkout;
import com.example.security20.entity.UserPhysicalParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportOfWorkoutRepository extends JpaRepository<ReportOfWorkout, Long> {
    @Query(value = "SELECT * FROM report_of_workout r WHERE user_id = :userId ORDER BY r.date DESC", nativeQuery = true)
    List<ReportOfWorkout> findReportOfWorkoutByUserId(@Param("userId") Long userId);


    @Modifying
    @Query(value = "UPDATE report_of_workout SET exercises = :exercises, reports = :reports WHERE id = :id", nativeQuery = true)
    void updateReportOfWorkoutById(@Param("id") Long id,
                               @Param("exercises") String exercises,
                               @Param("reports") String reports);
}
