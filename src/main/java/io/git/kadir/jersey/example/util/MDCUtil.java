package io.git.kadir.jersey.example.util;

import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author akadir
 * Date: 2019-05-16
 * Time: 21:43
 */
public class MDCUtil {
    private MDCUtil() {
    }

    public static void setUpMDC(HttpServletRequest servletRequest) {
        String remoteHost = servletRequest.getRemoteHost();
        String remoteAddr = servletRequest.getRemoteAddr();
        int remotePort = servletRequest.getRemotePort();
        String uniqueID = UUID.randomUUID().toString();
        MDC.put(Constants.REQUEST_ID_KEY, uniqueID);
        MDC.put(Constants.REMOTE_ADDRESS_KEY, remoteAddr);
        MDC.put(Constants.REMOTE_PORT_KEY, String.valueOf(remotePort));
        MDC.put(Constants.REMOTE_HOST_KEY, remoteHost);
    }

    public static void tearDownMDC() {
        MDC.clear();
    }
}
