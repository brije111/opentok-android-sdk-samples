package com.tokbox.android.tutorials.basicvideochat;

import android.webkit.URLUtil;

public class OpenTokConfig {
    // *** Fill the following variables using your own Project info from the OpenTok dashboard  ***
    // ***                      https://dashboard.tokbox.com/projects                           ***

    // Replace with your OpenTok API key
    public static final String API_KEY = "45952702";
    // Replace with a generated Session ID
    public static final String SESSION_ID = "1_MX40NTk1MjcwMn5-MTUwNDYwNDQ3NzE2MH5KaVNsbXp5VmVVQkZUZ0ZRR2RlejA5Yzd-fg";
    // Replace with a generated token (from the dashboard or using an OpenTok server SDK)
    public static final String TOKEN = "T1==cGFydG5lcl9pZD00NTk1MjcwMiZzaWc9NjMyM2M0N2MxOGZkMTYyMzVmZjFjZTA5YzUwNDgyNjA4NjI1YmU1ODpzZXNzaW9uX2lkPTFfTVg0ME5UazFNamN3TW41LU1UVXdORFl3TkRRM056RTJNSDVLYVZOc2JYcDVWbVZWUWtaVVowWlJSMlJsZWpBNVl6ZC1mZyZjcmVhdGVfdGltZT0xNTA0NjA0NTE0Jm5vbmNlPTAuMzExNjc0OTE1MDMxMzQwNyZyb2xlPXB1Ymxpc2hlciZleHBpcmVfdGltZT0xNTA0NjA4MTExJmluaXRpYWxfbGF5b3V0X2NsYXNzX2xpc3Q9";

    /*                           ***** OPTIONAL *****
     If you have set up a server to provide session information replace the null value
     in CHAT_SERVER_URL with it.

     For example: "https://yoursubdomain.com"
    */
    public static final String CHAT_SERVER_URL = null;
    public static final String SESSION_INFO_ENDPOINT = CHAT_SERVER_URL + "/session";


    // *** The code below is to validate this configuration file. You do not need to modify it  ***

    public static String webServerConfigErrorMessage;
    public static String hardCodedConfigErrorMessage;

    public static boolean areHardCodedConfigsValid() {
        if (OpenTokConfig.API_KEY != null && !OpenTokConfig.API_KEY.isEmpty()
                && OpenTokConfig.SESSION_ID != null && !OpenTokConfig.SESSION_ID.isEmpty()
                && OpenTokConfig.TOKEN != null && !OpenTokConfig.TOKEN.isEmpty()) {
            return true;
        }
        else {
            hardCodedConfigErrorMessage = "API KEY, SESSION ID and TOKEN in OpenTokConfig.java cannot be null or empty.";
            return false;
        }
    }

    public static boolean isWebServerConfigUrlValid(){
        if (OpenTokConfig.CHAT_SERVER_URL == null || OpenTokConfig.CHAT_SERVER_URL.isEmpty()) {
            webServerConfigErrorMessage = "CHAT_SERVER_URL in OpenTokConfig.java must not be null or empty";
            return false;
        } else if ( !( URLUtil.isHttpsUrl(OpenTokConfig.CHAT_SERVER_URL) || URLUtil.isHttpUrl(OpenTokConfig.CHAT_SERVER_URL)) ) {
            webServerConfigErrorMessage = "CHAT_SERVER_URL in OpenTokConfig.java must be specified as either http or https";
            return false;
        } else if ( !URLUtil.isValidUrl(OpenTokConfig.CHAT_SERVER_URL) ) {
            webServerConfigErrorMessage = "CHAT_SERVER_URL in OpenTokConfig.java is not a valid URL";
            return false;
        } else {
            return true;
        }
    }
}
