package com.View.Impl;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.Transaksi;
import com.View.TransaksiService;
import com.repository.transaksi_repo;

@Service
@Transactional
public class TransaksiPaymentImple implements TransaksiService{
    
    @Autowired
    public transaksi_repo repo;

    @Override
    public Map save(Transaksi transaksi) {
        // TODO Auto-generated method stub
        Map map = new HashMap();
        try{
            Transaksi save = repo.save(transaksi);
            map.put("data", save);
            map.put("code", "200");
            map.put("status", "success");
            return map;
        } catch (Exception e){
            map.put("code", "500");
            map.put("status", "failed");
            return map;

        }        
        
    }

    @Override
    public Map updateStatus(Transaksi transaksi) {
        // TODO Auto-generated method stub
        Map map = new HashMap();
        try{
            Transaksi update = repo.getbyID(transaksi.getId());
            update.setStatus("Lunas");
            Transaksi doSave = repo.save(update);
            map.put("data", doSave);
            map.put("code", "200");
            map.put("status", "success");
            return map;
        } catch(Exception e){
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }

    }
   
    
}
