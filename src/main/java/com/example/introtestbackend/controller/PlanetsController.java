package com.example.introtestbackend.controller;

import com.example.introtestbackend.problems.planet.Planet_Problem;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/planets")
public class PlanetsController {

    @PostMapping("/reachability")
    public String reachable(@RequestBody(required = true) Planet_Problem problem) {
        // Create a directed graph
        Graph<String, DefaultEdge> graph = createGraph(problem);

        ConnectivityInspector<String, DefaultEdge> connectivityInspector = new ConnectivityInspector<>(graph);
        Set<String> reachable = connectivityInspector.connectedSetOf(problem.start);
        return "Vertices reachable: " + reachable;
    }

    @PostMapping("/connected")
    public String connected(@RequestBody(required = true) Planet_Problem problem) {
        // Create a directed graph
        Graph<String, DefaultEdge> graph = createGraph(problem);

        KosarajuStrongConnectivityInspector<String, DefaultEdge> inspector = new KosarajuStrongConnectivityInspector<>(graph);
        boolean isStronglyConnected = inspector.isStronglyConnected();
        return "Is the graph strongly connected?: " + isStronglyConnected;
    }

    @PostMapping("/shortestPath")
    public String shortestPath(@RequestBody(required = true) Planet_Problem problem) {
        // Create a directed graph
        Graph<String, DefaultWeightedEdge> graph = createWeightedGraph(problem);

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
        GraphPath<String, DefaultWeightedEdge> path = dijkstra.getPath(problem.start, problem.destination);

        return "Shortest Path: " + path + " with weight " + path.getWeight();

    }

    @PostMapping("/expensivePath")
    public String expensivePath(@RequestBody(required = true) Planet_Problem problem) {
        // Create a directed graph
        Graph<String, DefaultWeightedEdge> graph = createWeightedInvertedGraph(problem);

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
        GraphPath<String, DefaultWeightedEdge> path = dijkstra.getPath(problem.start, problem.destination);

        return "Most Expensive Path: " + path;
    }

    public static Graph<String, DefaultEdge> createGraph(Planet_Problem problem){

        // Create a directed graph
        Graph<String, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

        // Add planets as vertices
        for (String planet : problem.getPlanets()) {
            graph.addVertex(planet);
        }

        // Add portals as edges
        for (Planet_Problem.Portal portal : problem.getPortals()) {
            graph.addEdge(portal.getFrom(), portal.getMyto());
        }

        return graph;

    }

    public static Graph<String, DefaultWeightedEdge> createWeightedGraph(Planet_Problem problem){

        // Create a directed graph
        Graph<String, DefaultWeightedEdge> graph = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        // Add planets as vertices
        for (String planet : problem.getPlanets()) {
            graph.addVertex(planet);
        }

        // Add portals as edges
        for (Planet_Problem.Portal portal : problem.getPortals()) {
            DefaultWeightedEdge edge = graph.addEdge(portal.getFrom(), portal.getMyto());
            graph.setEdgeWeight(edge, portal.distance);
        }

        return graph;

    }

    public static Graph<String, DefaultWeightedEdge> createWeightedInvertedGraph(Planet_Problem problem){

        // Create a directed graph
        Graph<String, DefaultWeightedEdge> graph = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        // Add planets as vertices
        for (String planet : problem.getPlanets()) {
            graph.addVertex(planet);
        }

        // Add portals as edges
        for (Planet_Problem.Portal portal : problem.getPortals()) {
            DefaultWeightedEdge edge = graph.addEdge(portal.getFrom(), portal.getMyto());
            double originalWeight = portal.distance;
            double invertedWeight = 1 / originalWeight;
            System.out.println("from: " + portal.getFrom() + " to: " + portal.getMyto());
            System.out.println(invertedWeight);
            graph.setEdgeWeight(edge, portal.distance);
        }

        return graph;

    }

}
