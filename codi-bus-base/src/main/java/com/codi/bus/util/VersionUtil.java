package com.codi.bus.util;

public class VersionUtil {
	
	public static final String VERSION_FORMAT = "Major.Minor.Revision";
	
	public static int[] getSubVersion(String version){
		String[] subs = version.split("\\.");
		if (subs.length != 3) {
			throw new IllegalArgumentException("Invalid version format " + version);
		}
		try {
			int major_v = Integer.parseInt(subs[0]);
			int minor_v = Integer.parseInt(subs[1]);
			int revision_v = Integer.parseInt(subs[2]);
			int[] res = new int[3];
			res[0] = major_v;
			res[1] = minor_v;
			res[2] = revision_v;
			return res;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid version format : " + version, e);
		}
	}
	
	/**
	 * 
	 * 0 means equal and -1 means small and 1 means great
	 * 
	 * */
	public static int compareAppVersion(String v1, String v2){
		if (v1.equals(v2)) {
			return 0;
		}
		int[] v1_subs = getSubVersion(v1);
		int[] v2_subs = getSubVersion(v2);
		for (int i = 0; i < 3; i++) {
			if (v1_subs[i] < v2_subs[i]) {
				return -1;
			}else if (v1_subs[i] == v2_subs[i]) {
				continue;
			} else{
				return 1;
			}
		}
		return 0;
	}
}
