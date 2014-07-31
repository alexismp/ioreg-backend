package org.alexismp.ioreg;

/**
 * Contains the client IDs and scopes for allowed clients consuming your API.
 */
public interface Constants {

    public static final String WEB_CLIENT_ID = "replace this with your web client ID";
    public static final String ANDROID_CLIENT_ID = "replace this with your Android client ID";
    public static final String IOS_CLIENT_ID = "replace this with your iOS client ID";
    public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;

    public static final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";

    public static final String DEFAULT_LIST = "{\"registrantList\": [ {        \n"
            + "        \"id\":\"12345678900987654321123456\",\n"
            + "\"customerId\":\"101932012361889521527\",\n"
            + "       \"num\":\"01NdZw12O2181\",\n"
            + "     \"email\":\"Joann.Barton@gtests.com\",\n"
            + "     \"first\":\"Joann\",\n"
            + "      \"last\":\"Barton\",\n"
            + "     \"title\":\"\",\n"
            + "  \"attrList\":[\n"
            + "       {\"name\":\"Attendee Type\", \"val\":\"Speaker\"},\n"
            + "       {\"name\":\"Checked-in\",\"val\":\"No\"},\n"
            + "       {\"name\":\"Shirt Size\",\"val\":\"XXL\"},\n"
            + "       {\"name\":\"Country\",\"val\":\"Morocco\"},\n"
            + "       {\"name\":\"Attendee Status\",\"val\":\"Approved\"},\n"
            + "       {\"name\":\"Picked-up\",\"val\":\"No\"},\n"
            + "       {\"name\":\"Counter\",\"val\":\"Speakers / Session Staff\"}],\n"
            + "     \"additionalInfo2\":\"2014-06-13T13:34:59.454Z\",\n"
            + "     \"additionalInfo3\":\"370700001E4961\"}\n"
            + "   ]\n"
            + "}";
    public static String SINGLE_ATTENDEE = "        \n"
            + "        \"id\":\"3\",\n"
            + "\"customerId\":\"3\",\n"
            + "       \"num\":\"TestsAlexisMP_3\",\n"
            + "     \"email\":\"Teri.Curtis@gtests.com\",\n"
            + "     \"first\":\"Teri\",\n"
            + "      \"last\":\"Curtis\",\n"
            + "     \"title\":\"CTO\",\n"
            + "  \"attrList\":[\n"
            + "       {\"name\":\"Attendee Type\", \"val\":\"Staff\"},\n"
            + "       {\"name\":\"Checked-in\",\"val\":\"No\"},\n"
            + "       {\"name\":\"Shirt Size\",\"val\":\"XXXL\"},\n"
            + "       {\"name\":\"Country\",\"val\":\"India\"},\n"
            + "       {\"name\":\"Attendee Status\",\"val\":\"Approved\"},\n"
            + "       {\"name\":\"Picked-up\",\"val\":\"No\"},\n"
            + "       {\"name\":\"Counter\",\"val\":\"Speakers / Session Staff\"}]}";
}
