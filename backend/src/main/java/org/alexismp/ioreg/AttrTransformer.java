package org.alexismp.ioreg;

import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.api.server.spi.config.Transformer;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.alexismp.ioreg.model.Attributes;

/**
* From :        {
* //               "name":"Attendee Type",
* //               "val":"Type1"
* //            }
* 
* to :
*               "Attendee Type": "Type1"
* 
* // JSON notation differences
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
*/
public class AttrTransformer implements Transformer<Attributes, String> {

    @Override
    public String transformTo(Attributes tfrom) {
        StringBuilder result = new StringBuilder();
        String propertyName;
        String propertyValue;
        
        Class<?> c = tfrom.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            try {
                if (result.length() != 0) {
                    result.append(",");
                }
                // use annotation name, not attribute name
                propertyName = f.getAnnotation(ApiResourceProperty.class).name();
                Object o = f.get(tfrom);
                propertyValue = (o == null) ? "Undefined!" : o.toString();
                result.append("{");
                result.append("\"name\":\"" + propertyName + "\",");
                result.append("\"val\":\"" + propertyValue + "\"");
                result.append("}");
                
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(AttrTransformer.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        
        String fullResult = "[" + result.toString() + "]";
        
        System.out.println("attrList :" + fullResult);
        return fullResult;
    }

    @Override
    public Attributes transformFrom(String tto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
