package com.example.introtestbackend.controller;

import com.example.introtestbackend.problems.hyperloop.Hyperloop;
import com.example.introtestbackend.problems.hyperloop.Hyperloop_Problem;
import com.example.introtestbackend.problems.hyperloop.Hyperloop_Solution;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hyperloop")
public class HyperloopController {

    @PostMapping
    public Hyperloop_Solution solve(@RequestBody(required = true) Hyperloop_Problem problem) {
        return new Hyperloop().solveStage(problem);
    }

}
