/**
 * https://leetcode.com/problems/design-underground-system/submissions/
 */
package com.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author satis
 *
 */
class Passenger {
	int checkInTime;
	int checkOutTime;
	String checkInStation;
	String checkOutStation;

	public Passenger(String stationName, int t) {
		this.checkInTime = t;
		this.checkInStation = stationName;
	}

	public void checkOut(String stationName, int t) {
		this.checkOutStation = stationName;
		this.checkOutTime = t;
	}
}

class Route {
	int totalTime;
	int count;

	public Route() {
		totalTime = 0;
		count = 0;
	}

	public double getAverage() {
		return (double) totalTime / count;
	}
}

public class UndergroundSystem {
	Map<Integer, Passenger> passengersRecord;
	Map<String, Route> checkInOutTracker;

	public UndergroundSystem() {
		passengersRecord = new HashMap<>();
		checkInOutTracker = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {
		Passenger currentPassenger = passengersRecord.getOrDefault(id, new Passenger(stationName, t));
		currentPassenger.checkInTime = t;
		currentPassenger.checkInStation = stationName;
		passengersRecord.put(id, currentPassenger);
	}

	public void checkOut(int id, String stationName, int t) {
		Passenger currentPassenger = passengersRecord.get(id);
		currentPassenger.checkOut(stationName, t);

		String routeKey = currentPassenger.checkInStation + "," + stationName;

		Route route = checkInOutTracker.getOrDefault(routeKey, new Route());
		route.totalTime += (t - currentPassenger.checkInTime);
		route.count += 1;
		checkInOutTracker.put(routeKey, route);
	}

	public double getAverageTime(String startStation, String endStation) {
		Route route = checkInOutTracker.get(startStation + "," + endStation);
		return route.getAverage();
	}
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t); obj.checkOut(id,stationName,t); double param_3
 * = obj.getAverageTime(startStation,endStation);
 */