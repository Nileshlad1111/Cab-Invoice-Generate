package com.bridgelabz;

public class RideCategory {
    public int COST_PER_KILOMETER ;
    public int COST_PER_MINUTE ;
    public int MINIMUM_COST ;

    enum rideType{
        NORMAL_RIDE, PREMIUM_RIDE;
    }

    public RideCategory(rideType type) {
        if(type == rideType.NORMAL_RIDE) {
            this.COST_PER_KILOMETER = 10;
            this.COST_PER_MINUTE = 1;
            this.MINIMUM_COST = 5;
        } else {
            this.COST_PER_KILOMETER = 15;
            this.COST_PER_MINUTE = 3;
            this.MINIMUM_COST = 20;
        }
    }
}
