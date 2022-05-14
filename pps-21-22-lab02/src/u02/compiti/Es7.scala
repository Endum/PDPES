object es7 extends App:
	@inline final val Pi = java.lang.Math.PI
	enum Shape:
		case Rectangle(base: Double, height: Double)
		case Circle(radious: Double)
		case Square(base: Double)
	object Shape:
		def perimeter(shape: Shape): Double = shape match
			case Rectangle(b, h) => 2 * (b + h)
			case Circle(r) => 2 * r * Pi
			case Square(b) => 4 * b
		def area(shape: Shape): Double = shape match
			case Rectangle(b, h) => b * h
			case Circle(r) => r * r * Pi
			case Square(b) => b * b
	println(Shape.area(Shape.Square(5)))
	println(Shape.perimeter(Shape.Circle(1/Pi)))