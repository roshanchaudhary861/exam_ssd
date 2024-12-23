package shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the {@link ShapeCollection} interface using an underlying ordered list.
 * 
 * @author mdixon
 */
public class ShapeList implements ShapeCollection {

	/**
	 * The list of shapes
	 */
	private List<Shape> shapes = new ArrayList<Shape>();

	///////////////////////////////////////////////////////////////////////

	@Override
	public int addShape(Shape shape) {

		// TODO PART4 : add the shape to the list, then return the size of the list once added.
		shapes.add(shape);
		return shapes.size();
	}

	@Override
	public boolean removeShape(Shape shape) {

		// TODO PART4 : remove the shape to the list, returning true if actually removed, else returning false.
		return shapes.remove(shape);
	}

	@Override
	public boolean containsShape(Shape shape) {

		// TODO PART4 : return true if the list contains the given shape, else return false.
		return shapes.contains(shape);
	}

	@Override
	public int shapeCount() {

		// TODO PART4 : return the size of the list
		return shapes.size();
	}

	@Override
	public void clearAllShapes() {

		// TODO PART4 : remove all elements from the list
		shapes.clear();
	}

	@Override
	public int indexOfShape(Shape shape) {

		// TODO PART4 : locate the given shape in the list, returning its index position.
		return shapes.indexOf(shape);
	}

	@Override
	public Shape getLargestShape() {

		double maxArea = Double.MIN_VALUE;
		Shape largest = null;

		// TODO PART4 : iterate the list, finding the shape with the largest area (hint: call getArea() for each shape)
		for (Shape shape : shapes) {
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

		double minArea = Double.MAX_VALUE;
		Shape smallest = null;

		// TODO PART4 : iterate the list, finding the shape with the smallest area
		for (Shape shape : shapes) {
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

		int count = 0;

		// TODO PART4 : Check if given colour is null
		// TODO PART4 : iterate the list, counting the number of shapes with the given colour
		// hint: call getColour() for each shape and compare with given colour using a method
		if (colour != null) {
			for (Shape shape : shapes) {
				if (colour.equals(shape.getColour())) {
					count++;
				}
			}
		}
		return count;
	}
	
	///////////////////////////////////////////////////////////////////////

}
