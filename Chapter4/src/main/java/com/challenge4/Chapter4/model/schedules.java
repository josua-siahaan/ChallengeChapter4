package com.challenge4.Chapter4.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "schedules", schema = "public")
public class schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private int schedule_id;
    @Column(name = "film_code")
    private int film_code;
    @Column(name = "tanggal_tanyang")
    private Date tanggal_tanyang;
    @Column(name = "jam_mulai")
    private String jam_mulai;
    @Column(name = "jam_selesai")
    private String jam_selesai;
    @Column(name = "harga_tiket")
    private String harga_tiket;

}
