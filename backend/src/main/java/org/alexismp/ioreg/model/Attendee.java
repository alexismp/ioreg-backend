package org.alexismp.ioreg.model;

import com.google.api.server.spi.config.ApiResourceProperty;

public class Attendee {
    // be careful, JSON names are derived from identifiernames
    @ApiResourceProperty(name="id")
    public String id;
    @ApiResourceProperty(name="customerId")
    public String googlePlusId;   // G+ id?
    @ApiResourceProperty(name="num")
    public String num;
    @ApiResourceProperty(name="email")
    public String email;
    @ApiResourceProperty(name="first")
    public String first;
    @ApiResourceProperty(name="last")
    public String last;
    @ApiResourceProperty(name="title")
    public String title;
    @ApiResourceProperty(name="additionalInfo3")    // TODO: check
    public String checkinTime;
    
    @ApiResourceProperty(name="attrList")
    public Attributes attrList;
    
    public Attendee(String id, String customerId, String num, String email,
            String first, String lastName, String title, String checkinTime) {
        this.id = id;
        this.googlePlusId = customerId;
        this.num = num;
        this.email = email;
        this.first = first;
        this.last = lastName;
        this.title = title;
        this.checkinTime = checkinTime;
        attrList = new Attributes();
        attrList.attendeeType = "Attendee";
    }
    
    // Attendee created with just name and checked-in status set to TRUE
    public Attendee(String first, String last) {
        this (System.currentTimeMillis()+"", // id, unique (in theory)
                "123456789012345678901", // googlePlusId
                "num??",    // Num. TODO: use?
                first + "." + last + "@gtest.com",  //email
                first,     // first
                last,      // lastName
                "M.",       // title                
                "2014-05-24-15.03.59.000000");        // time
        attrList.checkedIn = true;
        attrList.counter = "Checked-in";
    }
    
    // random attendee, created as NOT checked-in
    public Attendee() {
        this (System.currentTimeMillis()+"", // id, unique (in theory)
                "123456789012345678901", // googlePlusId
                "num??",    // Num. TODO: use?
                "email@gtest.com",  //email
                "John",     // first
                "Doe",      // lastName
                "Dr.",      // title
                "yyyy-MM-dd-hh.mm.ss.ffffff");    // time
        attrList.checkedIn = false;
        attrList.counter = "Not checked-in";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGooglePlusId() {
        return googlePlusId;
    }

    public void setGooglePlusId(String googlePlusId) {
        this.googlePlusId = googlePlusId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Attributes getAttrList() {
        return attrList;
    }

    public void setAttrList(Attributes attrList) {
        this.attrList = attrList;
    }


}
