package gui_swing_events;

/**
 *
 * @author 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new SwingEventWindow(true);
        
        Excel excel = new Excel("10 20 30 -10 -1");
        
        // testing
        System.out.println("Total: " + excel.findTotal());
        System.out.println("Average: " + excel.findAverage());
        System.out.println("Max No: " + excel.findMax());
        System.out.println("Min No: " + excel.findMin());
    }
    
}
