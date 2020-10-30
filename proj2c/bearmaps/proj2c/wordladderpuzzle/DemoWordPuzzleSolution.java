package bearmaps.proj2c.wordladderpuzzle;


import bearmaps.proj2c.LazySolver;
import bearmaps.proj2c.ShortestPathsSolver;
import bearmaps.proj2c.SolutionPrinter;

/**
 * Showcases how the AStarSolver can be used for solving word ladders.
 * NOTE: YOU MUST REPLACE LazySolver WITH AStarSolver OR THIS DEMO WON'T WORK!
 * Make sure to set your current working directory to be the one
 * containing words10000.txt.
 * Created by hug.
 */
public class DemoWordPuzzleSolution {
    public static void main(String[] args) {
        String start = "horse";
        String goal = "nurse";

        WordGraph wg = new WordGraph();

        ShortestPathsSolver<String> solver = new LazySolver<>(wg, start, goal, 10);
        SolutionPrinter.summarizeSolution(solver, "->");
    }
}
