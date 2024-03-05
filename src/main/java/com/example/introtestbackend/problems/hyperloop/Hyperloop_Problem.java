package com.example.introtestbackend.problems.hyperloop;

import java.util.ArrayList;

public class Hyperloop_Problem {

    public Hyperloop_Problem.Obstacle obstacle;
    public ArrayList<Target> targets;

    public static class Target{
        public int x;
        public int y;
    }

    public static class Obstacle{

        public int line;
        public Hyperloop_Problem.PointB pointB;
        public Hyperloop_Problem.PointA pointA;
    }

    public static class PointA{
        public int x;
        public int y;
    }

    public static class PointB{
        public int x;
        public int y;
    }

}
