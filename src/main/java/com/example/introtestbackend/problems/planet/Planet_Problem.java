package com.example.introtestbackend.problems.planet;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Planet_Problem {

    public ArrayList<String> planets;
    public ArrayList<Portal> portals;
    public String start;
    public String destination;

    public ArrayList<String> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<String> planets) {
        this.planets = planets;
    }

    public ArrayList<Portal> getPortals() {
        return portals;
    }

    public void setPortals(ArrayList<Portal> portals) {
        this.portals = portals;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public static class Portal{
        public String from;
        @JsonProperty("to")
        public String myto;

        public int distance;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getMyto() {
            return myto;
        }

        public void setMyto(String myto) {
            this.myto = myto;
        }

        @Override
        public String toString() {
            return "Portal{" +
                    "from='" + from + '\'' +
                    ", myto='" + myto + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Planet_Problem{" +
                "planets=" + planets +
                ", portals=" + portals +
                ", start='" + start + '\'' +
                '}';
    }
}
