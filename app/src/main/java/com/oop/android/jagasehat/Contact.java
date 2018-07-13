package com.oop.android.jagasehat;

/**
 * Created by Asus on 20/06/2018.
 */

public class Contact {
    private String kelompok;
    private String alamat;
    private String nomor;
    private String koordinat;

    public Contact(String kelompok, String alamat, String nomor, String koordinat) {
        this.kelompok = kelompok;
        this.alamat = alamat;
        this.nomor = nomor;
        this.koordinat = koordinat;
    }

    public String getKelompok() {
        return kelompok;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNomor() {
        return nomor;
    }

    public String getKoordinat() {
        return koordinat;
    }
}