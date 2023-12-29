import edu.duke.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int i = 0;
        for (Point p : s.getPoints()) {
            i = i + 1;
            //System.out.println(p);
        }
        return i;
    }

    public double getAverageLength(Shape s) {
        int i = 0;
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
            i = i+1;
        }
        // totalPerim is the answer
        return totalPerim/i;
        
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double lar_side = 0.0;
        List<Double> list = new ArrayList<Double>();
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            list.add(currDist);
            // Update prevPt to be currPt
            prevPt = currPt;
            lar_side = Collections.max(list);
        }
        // totalPerim is the answer
        return lar_side;
        
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        List<Double> list = new ArrayList<Double>();
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double Xcord = prevPt.getX();
            list.add(Xcord);
            // Update prevPt to be currPt
            prevPt = currPt;
            largestX = Collections.max(list);
        }
        // totalPerim is the answer
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestP = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s) > largestP){
                largestP = getPerimeter(s);
            }
        }
        return largestP;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largestP = 0.0;
        DirectoryResource dir = new DirectoryResource();
        for (File f : dir.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s) > largestP){
                largestP = getPerimeter(s);
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int num_points = getNumPoints(s);
        double ave_length = getAverageLength(s);
        double largest_side = getLargestSide(s);
        double largestX = getLargestX(s);
        double LargestP = getLargestPerimeterMultipleFiles();
        String filename = getFileWithLargestPerimeter();
        System.out.println("perimeter = " + length);
        System.out.println("Number of Points = " + num_points);        
        System.out.println("Average Length = " + ave_length);
        System.out.println("Largest Side = " + largest_side);
        System.out.println("Largest XSide = " + largestX);        
        System.out.println("LargestP = " + LargestP);
        System.out.println("LargestP = " + filename);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
