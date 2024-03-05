package com.example.introtestbackend.problems.hyperloop;

import java.util.ArrayList;

public class Hyperloop {

    public Hyperloop_Solution solveStage(Hyperloop_Problem problem){

        Hyperloop_Solution solution = new Hyperloop_Solution();
        solution.accessiblePoints = new ArrayList<>();

        double angle1 = 0;
        double angle2 = 0;
        boolean useAngle = false;
        boolean useLine = false;
        if (problem.obstacle.pointA != null && problem.obstacle.pointB != null){
            useAngle = true;
            angle1 = Math.atan2(problem.obstacle.pointA.y, problem.obstacle.pointA.x);
            angle2 = Math.atan2(problem.obstacle.pointB.y, problem.obstacle.pointB.x);
        }

        for (var target:problem.targets) {

            double angle = Math.atan2(target.y, target.x);

            boolean outsideAngle1 = false;
            boolean outsideAngle2 = false;
            boolean outsideAngleLine1 = false;
            boolean outsideAngleLine2 = false;

            if (useAngle) {
                outsideAngle1 = (angle1 > angle2) && (!(angle < angle1 && angle > angle2));
                outsideAngle2 = (angle1 < angle2) && (!(angle < angle2 && angle > angle1));
            }

            outsideAngleLine1 = problem.obstacle.line < 0 && problem.obstacle.line < target.y;
            outsideAngleLine2 = problem.obstacle.line > 0 && problem.obstacle.line > target.y;

            if (outsideAngle1 || outsideAngle2 || outsideAngleLine1 || outsideAngleLine2){

                var point = new Hyperloop_Solution.AccessiblePoint();
                point.x = target.x;
                point.y = target.y;
                solution.accessiblePoints.add(point);

            }
        }

        return solution;

    }

}
