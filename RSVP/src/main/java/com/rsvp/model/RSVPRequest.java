package com.rsvp.model;


public class RSVPRequest {
    private String name;
    private int attendingNum;
    private int attendingVeg;
    private int attendingNonVeg;

    public RSVPRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAttendingNum() { return attendingNum; }
    public void setAttendingNum(int attendingNum) { this.attendingNum = attendingNum; }

    public int getAttendingVeg() { return attendingVeg; }
    public void setAttendingVeg(int attendingVeg) { this.attendingVeg = attendingVeg; }

    public int getAttendingNonVeg() { return attendingNonVeg; }
    public void setAttendingNonVeg(int attendingNonVeg) { this.attendingNonVeg = attendingNonVeg; }
}

