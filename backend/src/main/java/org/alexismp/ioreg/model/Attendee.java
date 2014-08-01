package org.alexismp.ioreg.model;

import com.google.api.server.spi.config.ApiResourceProperty;

public class Attendee {
    // be careful, JSON names are derived from identifiernames
    @ApiResourceProperty(name="id")
    public String id;
    @ApiResourceProperty(name="customerId")
    public String googlePlusId;
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
        attrList = new Attributes();
        attrList.checkedIn = true;
        attrList.checkinTime = checkinTime;
        attrList.counter = "Googlers / Youth";
        attrList.attendeeType = "Googler";
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
                "2014-08-01T11:39:41.058Z");        // time
        attrList.checkedIn = true;
        attrList.counter = "A-B";
        attrList.shirtSize = "L";
        attrList.attendeeType = "Attendee";
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
                "2014-08-01T08:29:41.058Z");    // time
        attrList.checkedIn = false;
        attrList.counter = "Sandbox";
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

    public Attributes getAttrList() {
        return attrList;
    }

    public void setAttrList(Attributes attrList) {
        this.attrList = attrList;
    }


}
