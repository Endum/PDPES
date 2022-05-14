val p1: Double => Double => Double => Boolean = x => y => z => x <= y && y <= z
val p2 = (x:Double, y:Double, z:Double) => x <= y && y <= z
def p3(x: Double)(y: Double)(z: Double): Boolean = x <= y && y <= z
def p4(x: Double, y: Double, z: Double): Boolean = x <= y && y <= z
