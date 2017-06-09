package com.example.user.tolet;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by USER on 5/29/2017.
 */

public class TaskItem implements Serializable {
    public int iD;
    public String HouseNo;
    public String RoadNo;
    public String Thana;
    public String District;
    public String PostAddress;
    public String ContactNo;
    public String isBachelor;
    public String ImageUri;

    public String getImageUri() {
        return ImageUri;
    }

    public ImageView imageView;
    public Bitmap byteImage;



    public TaskItem(){byteImage=null;}


    public ImageView getImageView() {
        return imageView;
    }

    public TaskItem(int _id, String house, String road, String thana, String district, String postAddress, String contactNo) {
        iD=_id;
        HouseNo=house;
        RoadNo=road;
        Thana=thana;
        District=district;
        PostAddress=postAddress;
        ContactNo=contactNo;
    }
    public void setByteImage(Bitmap byteImage) {
        this.byteImage = byteImage;
    }

    public Bitmap getByteImage() {
        return byteImage;
    }

    public String getHouseNo() {
        return HouseNo;
    }

    public String getRoadNo() {
        return RoadNo;
    }

    public String getThana() {
        return Thana;
    }

    public String getDistrict() {
        return District;
    }

    public String getPostAddress() {
        return PostAddress;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public String getIsBachelor() {
        return isBachelor;
    }




    @Override
    public String toString() {
        return "TaskItem{" +
                "HouseNo='" + HouseNo + '\'' +
                ", RoadNo='" + RoadNo + '\'' +
                '}';
    }
}
