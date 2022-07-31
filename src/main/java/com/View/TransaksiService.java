package com.View;

import java.util.Map;

import com.Model.Transaksi;

public interface TransaksiService {
    public Map save(Transaksi transaksi);
    public Map updateStatus(Transaksi transaksi);
}
