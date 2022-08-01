package com.View;

// import org.hibernate.mapping.Map;

import java.util.Map;

import com.Model.Transaksi;

// import javax.transaction.Transaction;


public interface TransaksiService {
    public Map save(Transaksi transaksi);
    public Map updateStatus(Transaksi transaksi);
    
}
