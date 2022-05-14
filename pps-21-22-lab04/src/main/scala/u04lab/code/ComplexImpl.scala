package u04lab.code

case class ComplexImpl (override val re: Double, override val im: Double) extends Complex:
  override def +(c: Complex): Complex = ComplexImpl(re + c.re, im + c.im)
  //  (a + ib) (c + id) = (ac - bd) + i(ad + bc)
  override def *(c: Complex): Complex = ComplexImpl(re * c.re - im * c.im, re * c.im + im * c.re)

