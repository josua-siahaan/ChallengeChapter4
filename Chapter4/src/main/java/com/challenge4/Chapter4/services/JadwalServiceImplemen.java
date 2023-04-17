package com.challenge4.Chapter4.services;

import com.challenge4.Chapter4.model.Jadwal;
import com.challenge4.Chapter4.repository.SchaduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JadwalServiceImplemen implements JadwalService{
    private final SchaduleRepository schaduleRepository;
    @Autowired
    public JadwalServiceImplemen(SchaduleRepository schaduleRepository) {
        this.schaduleRepository = schaduleRepository;
    }

    @Override
    public Jadwal findByJadwal(Date jadwal) {
        Optional<Jadwal> result = schaduleRepository.findBytanggalTayang(jadwal);
        Jadwal jadwal1;
        if (result.isPresent()){
            jadwal1 = result.get();
        }
        else {
            throw new RuntimeException("Could not find film with status jadwal: " + jadwal);
        }
        return jadwal1;
    }
}
