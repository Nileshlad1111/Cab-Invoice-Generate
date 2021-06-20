package com.bridgelabz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<Integer, ArrayList<Ride>> listOfRides;

    public RideRepository() {
        listOfRides = new HashMap<>();
    }

    public void addRides(int userId, Ride[] rides) throws RideRepositoryException {
        if (rides == null)
            throw new RideRepositoryException(RideRepositoryException.ExceptionType.NULL_LIST, "Rides Empty");
        if (listOfRides.containsKey(userId))
            listOfRides.get(userId).addAll(Arrays.asList(rides));
        else
            listOfRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
    }

    public Ride[] getRides(int userId) throws RideRepositoryException {
        ArrayList<Ride> listOfRides = this.listOfRides.get(userId);
        if (listOfRides == null)
            throw new RideRepositoryException(RideRepositoryException.ExceptionType.NO_VALUE_FOUND, "No Rides Found");
        return listOfRides.toArray(new Ride[0]);
    }
}
