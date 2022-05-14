def fib(n: Int): Int = n match
     | case f if f < 2 => f
     | case _ => fib(n-1)+fib(n-2)
