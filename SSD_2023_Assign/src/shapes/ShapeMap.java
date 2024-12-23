package shapes;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements the {@link ShapeCollection} interface using an underlying map allowing the number of occurrences of each added shape to be counted.
 * 
 * If the same shape is added more than once, then it is not re-added, but its occurrence count is increased.
 * 
 * @author mdixon
 */
public class ShapeMap implements ShapeCollection {

	/**
	 * A collection which maps contained shapes to an occurrence count.
	 */
	private Map<Shape, Integer> shapes; // TODO PART5 : create a suitable map instance

	///////////////////////////////////////////////////////////////////////

	public ShapeMap() {
		this.shapes = new HashMap<>();
	}

	@Override
	public int addShape(Shape shape) {

		// TODO PART5 : add the shape to the map setting the correct associated occurrence count
		// if the shape was not already in the map, set the associated count to 1
		// otherwise increase the existing occurrence count.
		// finally, return the total number of key/value pairs in the map
		int count = shapes.getOrDefault(shape, 0);
		shapes.put(shape, count + 1);
		return shapes.size();
	}

	@Override
	public boolean removeShape(Shape shape) {

		// TODO PART5 : remove the shape if it exists and return true. Return false if it does not exist.
		if (shapes.containsKey(shape)) {
			shapes.remove(shape);
			return true;
		}
		return false;
	}

	@Override
	public boolean containsShape(Shape shape) {

		// TODO PART5 : check if the map contains the given shape as a key
		return shapes.containsKey(shape);
	}

	@Override
	public int shapeCount() {

		// TODO PART5 : return the number of key/value pairs in the map
		return shapes.size();
	}

	@Override
	public void clearAllShapes() {

		// TODO PART5 : remove all shapes form the map
		shapes.clear();
	}

	@Override
	public int indexOfShape(Shape shape) {

		// TODO PART5 : throw correct exception which indicates this is an unsupported operation
		throw new UnsupportedOperationException("indexOfShape operation is not supported in ShapeMap.");
	}

	@Override
	public Shape getLargestShape() {
		
		// TODO PART5 : iterate the map, and find the shape with the largest area
		double maxArea = Double.MIN_VALUE;
		Shape largest = null;
		for (Map.Entry<Shape, Integer> entry : shapes.entrySet()) {
			Shape shape = entry.getKey();
			double area = shape.getArea();
			if (area > maxArea) {
				maxArea = area;
				largest = shape;
			}
		}
		return largest;
	}

	@Override
	public Shape getSmallestShape() {
		
		// TODO PART5 : iterate the map, and find the shape with the smallest area
		double minArea = Double.MAX_VALUE;
		Shape smallest = null;
		for (Map.Entry<Shape, Integer> entry : shapes.entrySet()) {
			Shape shape = entry.getKey();
			double area = shape.getArea();
			if (area < minArea) {
				minArea = area;
				smallest = shape;
			}
		}
		return smallest;
	}

	@Override
	public int countShapeOfColour(String colour) {

		// TODO PART5 : iterate the map and count the shapes which are the given colour.
		int count = 0;
		for (Shape shape : shapes.keySet()) {
			if (shape.getColour().equals(colour)) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Gets the shape which has the highest occurrence count (i.e. has been added to the collection the most number of times).
	 * 
	 * @return the shape which has been added to the collection the most number of times, null if no shapes exist within the collection.
	 */
	public Shape getMostCommonShape() {
		
		Shape mostCommon = null;
		int maxCount = 0;
		for (Map.Entry<Shape, Integer> entry : shapes.entrySet()) {
			if (entry.getValue() > maxCount) {
				mostCommon = entry.getKey();
				maxCount = entry.getValue();
			}
		}
		return mostCommon;
	}
	
	/**
	 * Gets the occurrence count of the most common shape.
	 * 
	 * @return the occurrence count of the most common shape, 0 if no shapes exist within the collection.
	 */
	public int getMostCommonShapeCount() {

		Shape mostCommon = getMostCommonShape();
		if (mostCommon != null) {
			return shapes.get(mostCommon);
		} else {
			return 0;
		}
	}
	
	///////////////////////////////////////////////////////////////////////

}
