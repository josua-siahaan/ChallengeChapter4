package controller;

import com.challenge4.Chapter4.model.Jadwal;
import com.challenge4.Chapter4.services.JadwalService;
import com.challenge4.Chapter4.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/schadule")
public class SchadulesController {
    private final JadwalService jadwalService;
    private static final Map<String, Object> mapParams = new HashMap<String, Object>();
    private static final String SUCCES_MSG = "Successfully retrieved data!";

    @Autowired
    public SchadulesController(JadwalService jadwalService) {
        this.jadwalService = jadwalService;
    }
    @GetMapping
    public ResponseEntity<Object> findAllOrByArgument(
            @RequestParam(value = "tanggal_tayang", required = false)Date tanggal_tayang
            ){
        Jadwal jadwal= null;
        if (tanggal_tayang != null){
            jadwal = jadwalService.findByJadwal(tanggal_tayang);
        }
        return ResponseHandler.generateResponse(SUCCES_MSG, HttpStatus.OK, jadwal);
    }
    @GetMapping
    public ResponseEntity<Object> findByTanggalTayang(@PathVariable("tanggal_tayang") String tanggal_tayang){
        Jadwal jadwal1 = null;
        return ResponseHandler.generateResponse(SUCCES_MSG, HttpStatus.OK, jadwal1);
    }
}
