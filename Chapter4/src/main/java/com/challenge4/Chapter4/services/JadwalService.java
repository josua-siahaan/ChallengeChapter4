package com.challenge4.Chapter4.services;

import com.challenge4.Chapter4.model.Jadwal;

import java.util.Date;
import java.util.List;

public interface JadwalService {

    Jadwal findByJadwal(Date jadwal);
}
