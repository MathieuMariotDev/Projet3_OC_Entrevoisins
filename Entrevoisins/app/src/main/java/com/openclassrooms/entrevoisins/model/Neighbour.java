package com.openclassrooms.entrevoisins.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Property;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour implements Parcelable {


    /** Favorite */
    private boolean favorite;

    /** Identifier */
    private long id;

    /** Full name */
    private String name;

    /** Avatar */
    private String avatarUrl;

    /** Adress */
    private String address;

    /** Phone number */
    private String phoneNumber;

    /** About me */
    private String aboutMe;

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     */
    public Neighbour(long id, String name, String avatarUrl, String address,
                     String phoneNumber, String aboutMe,boolean favorite) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.aboutMe = aboutMe;
        this.favorite = favorite;
    }

        protected    Neighbour (Parcel in){   //constructor  //Protected ?
        id =in.readLong();                  //read and set saved values from parcel
        name=in.readString();
        avatarUrl=in.readString();
        address=in.readString();
        phoneNumber=in.readString();
        aboutMe=in.readString();
        favorite=in.readInt()==1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public boolean getFavorite (){return favorite;}

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) { // In this method you add all your class properties to the parcel which are needed to transfer.

        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeString(avatarUrl);
        parcel.writeString(phoneNumber);
        parcel.writeString(address);
        parcel.writeString(aboutMe);
        parcel.writeInt(favorite ? 1 : 0);


    }

    public static final Parcelable.Creator<Neighbour> CREATOR = new Parcelable.Creator<Neighbour>() {   ///This is the method which is used to bind everything together. Nothing much is done here.
        @Override
        public Neighbour createFromParcel(Parcel in) {
            return new Neighbour(in);
        }




        @Override
        public Neighbour[] newArray(int size) {
            return new Neighbour[size];
        }
    };
    /*public static Creator<Neighbour> getCREATOR() {
        return CREATOR;
    }*/
    @Override
    public int describeContents() {
        return 0;
    }
}