public class foo{
	// src: http://stackoverflow.com/a/19965362
	public String getNetworkType() {
		int networkType = telephonyManager.getNetworkType();
		switch (networkType) {
		case TelephonyManager.NETWORK_TYPE_1xRTT:
			return "1xRTT";
		case TelephonyManager.NETWORK_TYPE_CDMA:
			return "CDMA";
		case TelephonyManager.NETWORK_TYPE_EDGE:
			return "EDGE";
		case TelephonyManager.NETWORK_TYPE_EHRPD:
			return "eHRPD";
		case TelephonyManager.NETWORK_TYPE_EVDO_0:
			return "EVDO rev. 0";
		case TelephonyManager.NETWORK_TYPE_EVDO_A:
			return "EVDO rev. A";
		case TelephonyManager.NETWORK_TYPE_EVDO_B:
			return "EVDO rev. B";
		case TelephonyManager.NETWORK_TYPE_GPRS:
			return "GPRS";
		case TelephonyManager.NETWORK_TYPE_HSDPA:
			return "HSDPA";
		case TelephonyManager.NETWORK_TYPE_HSPA:
			return "HSPA";
		case TelephonyManager.NETWORK_TYPE_HSPAP:
			return "HSPA+";
		case TelephonyManager.NETWORK_TYPE_HSUPA:
			return "HSUPA";
		case TelephonyManager.NETWORK_TYPE_IDEN:
			return "iDen";
		case TelephonyManager.NETWORK_TYPE_LTE:
			return "LTE";
		case TelephonyManager.NETWORK_TYPE_UMTS:
			return "UMTS";
		case TelephonyManager.NETWORK_TYPE_UNKNOWN:
			return "Unknown";
		}
		return "Error";
	}
}