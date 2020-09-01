package designPatterns.abstractFactoryPattern;

/* @author Richa Rochna */

public class ColourFactory extends AbstractFactory{

	@Override
	Colour getColour(String color) {
		if(color == null){
			return null;
		}		

		if(color.equalsIgnoreCase("RED")){
			return new Red();

		}else if(color.equalsIgnoreCase("GREEN")){
			return new Green();

		}else if(color.equalsIgnoreCase("BLUE")){
			return new Blue();
		}

		return null;
	}

	@Override
	Shape getShape(String Shape) {
		return null;
	}

}
