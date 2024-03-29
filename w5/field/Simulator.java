package field;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a field containing
 * rabbits and foxes.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class Simulator
{
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 50;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 50;
    // The probability that a fox will be created in any given grid position.
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    // The probability that a rabbit will be created in any given grid position.
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;    

    // Lists of animals in the field. Separate lists are kept for ease of iteration.
    private List<Rabbit> rabbits;
    private List<Fox> foxes;
    // The current state of the field.
    private Field field;
    // A second field, used to build the next stage of the simulation.
    private Field updatedField;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private SimulatorView view;
    
    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }
    
    /**
     * Create a simulation field with the given size.
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width)
    {
        if(width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
        rabbits = new ArrayList<Rabbit>();
        foxes = new ArrayList<Fox>();
        field = new Field(depth, width);
        updatedField = new Field(depth, width);

        // Create a view of the state of each location in the field.
        view = new SimulatorView(depth, width);
        view.setColor(Rabbit.class, Color.orange);
        view.setColor(Fox.class, Color.blue);
        
        // Setup a valid starting point.
        reset();
    }
    
    /**
     * Run the simulation from its current state for a reasonably long period,
     * e.g. 500 steps.
     */
    public void runLongSimulation()
    {
        simulate(500);
    }
    
    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     * @param numSteps The number of steps to run for.
     */
    public void simulate(int numSteps)
    {
        for(int step = 1; step <= numSteps && view.isViable(field); step++) {
            simulateOneStep();
            try {

                Thread.sleep(100);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
        }
    }
    
    /**
     * Run the simulation from its current state for a single step.
     * Iterate over the whole field updating the state of each
     * fox and rabbit.
     */
    public void simulateOneStep()
    {
        step++;
        // Provide space for newborn rabbits.
        List<Rabbit> newRabbits = new ArrayList<Rabbit>();        
        // Let all rabbits act.
        for(Iterator<Rabbit> it = rabbits.iterator(); it.hasNext(); ) {
            Rabbit rabbit = it.next();
            rabbit.run(updatedField, newRabbits);
            if(!rabbit.isAlive()) {
                it.remove();
            }
        }
        // Add new born rabbits to the main list of rabbits.
        rabbits.addAll(newRabbits);
        
        // Provide space for newborn foxes.
        List<Fox> newFoxes = new ArrayList<Fox>();        
        // Let all foxes act.
        for(Iterator<Fox> it = foxes.iterator(); it.hasNext(); ) {
            Fox fox = it.next();
            fox.hunt(field, updatedField, newFoxes);
            if(!fox.isAlive()) {
                it.remove();
            }
        }
        // Add new born foxes to the main list of foxes.
        foxes.addAll(newFoxes);
        // Swap the field and updatedField at the end of the step.
        Field temp = field;
        field = updatedField;
        updatedField = temp;
        updatedField.clear();

        // Display the new field on screen.
        view.showStatus(step, field);
    }
        
    /**
     * Reset the simulation to a starting position.
     */
    public void reset()
    {
        step = 0;
        rabbits.clear();
        foxes.clear();
        field.clear();
        updatedField.clear();
        populate(field);
        
        // Show the starting state in the view.
        view.showStatus(step, field);
    }
    
    /**
     * Populate a field with foxes and rabbits.
     * @param field The field to be populated.
     */
    private void populate(Field field)
    {
        Random rand = new Random();
        field.clear();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Fox fox = new Fox(true);
                    fox.setLocation(row, col);
                    foxes.add(fox);
                    field.place(fox, row, col);
                }
                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Rabbit rabbit = new Rabbit(true);
                    rabbit.setLocation(row, col);
                    rabbits.add(rabbit);
                    field.place(rabbit, row, col);
                }
                // else leave the location empty.
            }
        }
        Collections.shuffle(rabbits);
        Collections.shuffle(foxes);
    }

    public static void main(String[] args) {
        Simulator sm = new Simulator();
        sm.simulate(100);
    }
}
