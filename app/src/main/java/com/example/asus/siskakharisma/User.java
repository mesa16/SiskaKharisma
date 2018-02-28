package com.example.asus.siskakharisma;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ASUS on 2/26/2018.
 */

public class User implements Parcelable {
    private String nama;
    private  String email;
    private String telepon;

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

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.email);
        dest.writeString(this.telepon);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.nama = in.readString();
        this.email = in.readString();
        this.telepon = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
