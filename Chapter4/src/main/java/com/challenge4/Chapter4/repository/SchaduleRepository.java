package com.challenge4.Chapter4.repository;

import com.challenge4.Chapter4.model.Jadwal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface SchaduleRepository extends JpaRepository<Jadwal, String> {
    @Query("SELECT f From schedules f WHERE f.tanggal_tayang =?1")
    Optional<Jadwal> findBytanggalTayang(Date Date);

}
