package io.git.kadir.jersey.example.util;

import io.git.kadir.jersey.example.entity.enumeration.auth.MDCKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.UUID;

/**
 * @author akadir
 * Date: 2019-05-16
 * Time: 21:43
 */
public class MDCUtil {
    private static final Logger logger = LoggerFactory.getLogger(MDCUtil.class);

    private MDCUtil() {
    }

    static {
        try {
            String hostIp = InetAddress.getLocalHost().getHostAddress();
            MDC.put(MDCKey.HOST_IP.getValue(), hostIp);
            logger.info("Set host-ip: {}", hostIp);
        } catch (Exception e) {
            logger.error("An error occurred while putting HOST_IP to MDC");
        }
    }

    public static void setUpMDC(HttpServletRequest servletRequest) {
        String remoteHost = servletRequest.getRemoteHost();
        String remoteAddr = servletRequest.getRemoteAddr();
        int remotePort = servletRequest.getRemotePort();
        String forwardedIp = servletRequest.getHeader("X-Forwarded-For");

        addRequestId();
        addForwardedIpIfExist(forwardedIp);
        addRemoteAddress(remoteAddr);
        addRemotePort(remotePort);
        addRemoteHost(remoteHost);
    }

    public static void tearDownMDC() {
        MDC.clear();
    }

    private static void addRemoteHost(String remoteHost) {
        MDC.put(MDCKey.REMOTE_HOST.getValue(), remoteHost);
    }

    private static void addRemoteAddress(String remoteAddress) {
        MDC.put(MDCKey.REMOTE_ADDRESS.getValue(), remoteAddress);
    }

    private static void addRemotePort(int remotePort) {
        MDC.put(MDCKey.REMOTE_PORT.getValue(), String.valueOf(remotePort));
    }

    public static void addUserId(String userId) {
        MDC.put(MDCKey.USER_ID.getValue(), userId);
    }

    private static void addRequestId() {
        String uniqueID = UUID.randomUUID().toString();
        MDC.put(MDCKey.REQUEST_ID.getValue(), uniqueID);
    }

    private static void addForwardedIpIfExist(String forwardedIp) {
        if (forwardedIp != null && !forwardedIp.isEmpty()) {
            forwardedIp = forwardedIp.split(",")[0];
            MDC.put(MDCKey.FORWARDED_ADDRESS.getValue(), forwardedIp);
        }
    }
}
