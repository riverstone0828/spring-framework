package com.example.tlo.common.util.useragent;

import com.example.tlo.config.logging.properties.UserDeviceProperties;
import com.example.tlo.config.logging.vo.UserDevice;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class UserAgentUtil {
    public static UserDevice getDeviceInfo(String userAgent, List<UserDeviceProperties> devices) {
        UserDevice result = new UserDevice();
        String REGEX_DEVICE = ".*(iPhone|iPad|Android|BlackBerry|Windows Phone).*";
        Pattern pattern = Pattern.compile(REGEX_DEVICE);
        Matcher matcher = pattern.matcher(userAgent);

        Optional<UserDeviceProperties> userDeviceProperty = null;
        if (matcher.find()) {
            log.debug("getDeviceInfo : " + matcher.group(1));
            String deviceInfo = matcher.group(1);
            userDeviceProperty = devices.stream().filter(o -> o.getName().equals(deviceInfo)).findFirst();
            result.setDevice("MOBILE");

            if (userDeviceProperty.isPresent()) {
                Pattern deviceInfoPattern = Pattern.compile(userDeviceProperty.get().getPatternRegex());
                Matcher deviceInfoMatcher = deviceInfoPattern.matcher(userAgent);
                if (deviceInfoMatcher.find()) {
                    String deviceVersionStr = deviceInfoMatcher.group(1);

                    if (!userDeviceProperty.get().getName().matches("(iPhone|iPad)")) {
                        result.setModel(deviceInfoMatcher.group(2));
                    } else {
                        result.setModel(userDeviceProperty.get().getName());
                    }

                    Pattern deviceVersionPattern = Pattern.compile(userDeviceProperty.get().getVersionRegex());
                    Matcher deviceVersionMatcher = deviceVersionPattern.matcher(deviceVersionStr);

                    if (deviceVersionMatcher.find()) {
                        String osVersion = deviceVersionMatcher.group(1);
                        StringBuilder sb = new StringBuilder();
                        if (userDeviceProperty.get().getOsTag() != null) {
                            sb.append(userDeviceProperty.get().getOsTag());
                            sb.append("_");
                        }
                        sb.append(osVersion);
                        result.setOs(sb.toString());
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            result.setDevice("PC");
        }

        return result;
    }

    public static String getClientOS(String userAgent) {
        String os = "";
        userAgent = userAgent.toLowerCase();
        if (userAgent.indexOf("windows nt 10.0") > -1) {
            os = "Windows10";
        } else if (userAgent.indexOf("windows nt 6.1") > -1) {
            os = "Windows7";
        } else if (userAgent.indexOf("windows nt 6.2") > -1 || userAgent.indexOf("windows nt 6.3") > -1) {
            os = "Windows8";
        } else if (userAgent.indexOf("windows nt 6.0") > -1) {
            os = "WindowsVista";
        } else if (userAgent.indexOf("windows nt 5.1") > -1) {
            os = "WindowsXP";
        } else if (userAgent.indexOf("windows nt 5.0") > -1) {
            os = "Windows2000";
        } else if (userAgent.indexOf("windows nt 4.0") > -1) {
            os = "WindowsNT";
        } else if (userAgent.indexOf("windows 98") > -1) {
            os = "Windows98";
        } else if (userAgent.indexOf("windows 95") > -1) {
            os = "Windows95";
        } else if (userAgent.indexOf("iphone") > -1) {
            os = "iPhone";
        } else if (userAgent.indexOf("ipad") > -1) {
            os = "iPad";
        } else if (userAgent.indexOf("android") > -1) {
            os = "android";
        } else if (userAgent.indexOf("mac") > -1) {
            os = "mac";
        } else if (userAgent.indexOf("linux") > -1) {
            os = "Linux";
        } else {
            os = "Other";
        }
        return os;
    }
}
