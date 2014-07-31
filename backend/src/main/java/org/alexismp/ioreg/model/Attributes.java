package org.alexismp.ioreg.model;

import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.api.server.spi.config.ApiTransformer;
import org.alexismp.ioreg.AttrTransformer;

@ApiTransformer(AttrTransformer.class)
public class Attributes {
    @ApiResourceProperty(name="attendeeType")
    public String attendeeType;
    @ApiResourceProperty(name="checkedIn")
    public boolean checkedIn = false;
    @ApiResourceProperty(name="size")
    public String shirtSize = "XXXXXS";
    @ApiResourceProperty(name="country")
    public String country;
    @ApiResourceProperty(name="attendeeStatus")
    public String attendeeStatus = "Approved";
    @ApiResourceProperty(name="pickedUp")
    public boolean pickedUp = false;
    @ApiResourceProperty(name="counter")
    public String counter;        

    public String getAttendeeType() {
        return attendeeType;
    }

    public void setAttendeeType(String attendeeType) {
        this.attendeeType = attendeeType;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public String getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(String shirtSize) {
        this.shirtSize = shirtSize;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAttendeeStatus() {
        return attendeeStatus;
    }

    public void setAttendeeStatus(String attendeeStatus) {
        this.attendeeStatus = attendeeStatus;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }
    
//    @Override
//    public String toString() {
//        JSONObject json = new JSONObject();
//        json.put("Attendee Type", attendeeType);
//        json.put("Counter", counter);
//        json.put("Shirt Size", shirtSize);
//        return json.toJSONString();
//    }
}


// JSON notation differences
// Expected:
//         "attrList":[
//            {
//               "name":"Attendee Type",
//               "val":"Type1"
//            },
//            {
//               "name":"Country",
//               "val":"United States"
//            }
//         ]
//
// AppEngine Endpoints:
//        "attrList": 
//            {
//               "Attendee Type": "Type1",
//               "Country": "Unites States"
//            }
