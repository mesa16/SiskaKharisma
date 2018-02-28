package com.example.asus.siskakharisma;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ASUS on 2/23/2018.
 */

public class Mahasiswa implements Parcelable {

    private String nim;
    private String nama;
    private String email;
    private String status;
    private String foto;


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Mahasiswa() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeString(this.nim);
        dest.writeString(this.nama);
        dest.writeString(this.email);
        dest.writeString(this.foto);
    }

    protected Mahasiswa(Parcel in) {
        this.status = in.readString();
        this.nim = in.readString();
        this.nama = in.readString();
        this.email = in.readString();
        this.foto = in.readString();
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel source) {
            return new Mahasiswa(source);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };
}
