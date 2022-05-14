def compose(f: Int=>Int, g: Int=>Int)(v: Int): Int = f(g(v))
def compose[X](f: X=>X, g: X=>X)(v: X): X = f(g(v))
