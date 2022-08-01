package com.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.Model.Transaksi;
import com.View.TransaksiService;
import com.repository.transaksi_repo;

@RestController
@RequestMapping("/v1/transaksi")
public class TransaksiController {
    @Autowired
    public transaksi_repo repo;

    @Autowired
    TransaksiService servis;

    @PostMapping("")
    public ResponseEntity<Map> save(@RequestBody Transaksi transaksi){
        Map save = servis.save(transaksi);
        return new ResponseEntity<Map>(save, HttpStatus.OK);
    }
    
    @PutMapping("")
    public ResponseEntity<Map> update(@RequestBody Transaksi transaksi) {
        Map update = servis.updateStatus(transaksi);
        return new ResponseEntity<Map>(update, HttpStatus.OK);// response
    }
    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<Page<Transaksi>> listByNamaLike(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String status) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Transaksi> list = null;
        if(status != null){
            list = repo.findByStatus("%"+status+"%", show_data);
        }else{
            list = repo.getList(show_data);
        }
        
        return new ResponseEntity<Page<Transaksi>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
