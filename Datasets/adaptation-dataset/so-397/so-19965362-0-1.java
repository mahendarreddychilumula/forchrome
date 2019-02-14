public class foo {
/**
 * You need to add:
 * 
 * <pre>
 *     <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
 * </pre>
 * 
 * in your AndroidManifest.xml.
 */
private String networkType() {
    TelephonyManager teleMan = (TelephonyManager)
            getSystemService(Context.TELEPHONY_SERVICE);
    int networkType = teleMan.getNetworkType();
    switch (networkType) {
        case TelephonyManager.NETWORK_TYPE_1xRTT: return "1xRTT";
        case TelephonyManager.NETWORK_TYPE_CDMA: return "CDMA";
        case TelephonyManager.NETWORK_TYPE_EDGE: return "EDGE";
        case TelephonyManager.NETWORK_TYPE_EHRPD: return "eHRPD";
        case TelephonyManager.NETWORK_TYPE_EVDO_0: return "EVDO rev. 0";
        case TelephonyManager.NETWORK_TYPE_EVDO_A: return "EVDO rev. A";
        case TelephonyManager.NETWORK_TYPE_EVDO_B: return "EVDO rev. B";
        case TelephonyManager.NETWORK_TYPE_GPRS: return "GPRS";
        case TelephonyManager.NETWORK_TYPE_HSDPA: return "HSDPA";
        case TelephonyManager.NETWORK_TYPE_HSPA: return "HSPA";
        case TelephonyManager.NETWORK_TYPE_HSPAP: return "HSPA+";
        case TelephonyManager.NETWORK_TYPE_HSUPA: return "HSUPA";
        case TelephonyManager.NETWORK_TYPE_IDEN: return "iDen";
        case TelephonyManager.NETWORK_TYPE_LTE: return "LTE";
        case TelephonyManager.NETWORK_TYPE_UMTS: return "UMTS";
        case TelephonyManager.NETWORK_TYPE_UNKNOWN: return "Unknown";
    }
    throw new RuntimeException("New type of network");
}
}