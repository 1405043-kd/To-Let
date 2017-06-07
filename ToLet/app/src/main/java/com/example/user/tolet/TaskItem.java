package com.example.user.tolet;

import java.io.Serializable;

/**
 * Created by USER on 5/29/2017.
 */

public class TaskItem implements Serializable {
    public String HouseNo;
    public String RoadNo;
    public String Thana;
    public String District;
    public String PostAddress;
    public String ContactNo;
    public String isBachelor;
    public TaskItem(){}
    public TaskItem(String house, String road, String thana, String district, String postAddress, String contactNo) {
        HouseNo=house;
        RoadNo=road;
        Thana=thana;
        District=district;
        PostAddress=postAddress;
        ContactNo=contactNo;
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
