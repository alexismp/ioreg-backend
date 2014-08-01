package org.alexismp.ioreg;

import com.google.api.server.spi.Constant;
import org.alexismp.ioreg.model.Attendee;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

// AllianceTech documentation :
//      http://wiki.alliancetech.com:8080/pages/viewpage.action?pageId=8618121
// Base URL for client : 
//      http://localhost:8080/_ah/api/io14reg/v1/
// HTTPS basic auth ignored for now. But this will work:
// https://foo:bar@conf-regist.appspot.com/_ah/api/io14reg/v1/restapi/registration/12
@Api(name = "io14reg",
        version = "v1",
        description = "Demo restful backend for I/O 2014 on-site registration application",
        title  = "I/O 2014 Registration Restful Backend" /*,
        namespace = @ApiNamespace(ownerDomain = "org.alexismp.ioreg",
                ownerName = "org.alexismp.ioreg",
                packagePath = "") */)
public class RegistrationAPI {

    // Storing in memory for now (will obviously not work with multiple AppEngine instances)
    public static List<Attendee> attendees = new ArrayList<>();

    public RegistrationAPI() throws InterruptedException {
        // add attendee with id set to 007.
        attendees.add(new Attendee("007", "007", "aNum", "some@email.foo", "James", "Bond", "Dr.", "2014-08-01T06:15:41.058Z"));
        // a few "checked-in" attendees
        attendees.add(new Attendee("John", "Doe")); Thread.sleep(150);
        attendees.add(new Attendee("Jack", "Mercy")); Thread.sleep(150);
        attendees.add(new Attendee("Joe", "Page")); Thread.sleep(150);
        // a few more random attendees
        attendees.add(new Attendee()); Thread.sleep(150);
        attendees.add(new Attendee()); Thread.sleep(150);
        attendees.add(new Attendee()); Thread.sleep(150);
    }

    @ApiMethod(name = "checked_in_attendees",
            clientIds = {Constant.API_EXPLORER_CLIENT_ID, Constants.WEB_CLIENT_ID},
            path = "restapi/registration/checked-in-list",
            httpMethod = HttpMethod.GET)
    public List<Attendee> getCheckedInAttendees() {
        List<Attendee> result = new ArrayList<>();
        for (Attendee attendee : attendees) {
            if (attendee.attrList.checkedIn) {
                result.add(attendee);
            }
        }
        System.out.println("Returning " + result.size() + " attendees.");
        return result;
    }

    @ApiMethod(name = "get_attendee",
            path = "restapi/registration/{id}",
            httpMethod = HttpMethod.GET)
    public Attendee getAttendee(@Named("id") String id) throws NotFoundException {
        System.out.println("Getting attendee " + id);
        if (!attendees.isEmpty()) {
            return attendees.get(0);    // TODO: returns first attendee
        } else {
            throw new NotFoundException("Empty set of attendees");
        }
    }

    @ApiMethod(name = "set_picked_up",
            path = "restapi/registration/{id}",
            httpMethod = HttpMethod.POST)
    public void setPickedUp(@Named("id") String id) throws NotFoundException {
        if (!attendees.isEmpty()) {
            attendees.get(0).attrList.pickedUp = true;
        } else {
            throw new NotFoundException("Empty set of attendees");
        }
    }

}
