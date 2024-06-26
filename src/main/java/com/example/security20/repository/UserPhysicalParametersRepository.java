package com.example.security20.repository;

import com.example.security20.entity.UserPhysicalParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserPhysicalParametersRepository extends JpaRepository<UserPhysicalParameters,Long> {
    @Query(value = "SELECT * FROM user_phys_parameters u WHERE user_id = :userId ORDER BY u.date DESC", nativeQuery = true)
    List<UserPhysicalParameters> findPhysicalParametersByUserId(@Param("userId") Long userId);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user_phys_parameters u WHERE user_id = :userId", nativeQuery = true)
    void deletePhysicalParametersByUserId(@Param("userId") Long userId);

}
