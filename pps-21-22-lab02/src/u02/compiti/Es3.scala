A) 
val r: Int => String = _ match
     | case e if e % 2 == 0 => "even"
     | case _ => "odd"

def r (n: Int): String = n match
     | case e if e % 2 == 0 => "even"
     | case _ => "odd"

B)
val neg: (String => Boolean) => (String => Boolean) = sb => !sb(_)

C)
def neg[X](sb:X=>Boolean): X=>Boolean = !sb(_)