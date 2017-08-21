package com.vincent.eatr.util;

public class Util {
	/**
	 * Earth’s radius in kilometers
	 */
	public static final double R = 6371;

	/**
	 * Haversine formula to calculate the Great-circle distance between two
	 * points on a sphere from their longitudes and latitudes
	 * 
	 * a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2) 
	 * c = 2 ⋅ atan2( √a, √(1−a) )
	 * d = R ⋅ c
	 * 
	 * where φ is latitude, λ is longitude, R is earth’s radius (mean radius =
	 * 6,371km) note that angles need to be in radians
	 * 
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @return Great-circle distance in kilometers
	 */
	public static double haversine(float lat1, float lon1, float lat2, float lon2) {

		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);

		lat1 = (float) Math.toRadians(lat1);
		lat2 = (float) Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = R * c;

		return dist;
	}
}