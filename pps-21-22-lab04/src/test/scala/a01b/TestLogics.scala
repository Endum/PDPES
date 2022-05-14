package a01b

import org.junit.*
import org.junit.Assert.*
import u04lab.polyglot.a01b.*
import u04lab.code.List
import u04lab.code.List.*
import u04lab.polyglot.OptionToOptional

class TestLogics:

  val size = 3
  val mines = 2

  val logics: Logics = LogicsImpl(size, mines)

  @Test def testNotWinningOnStart()=
    assertFalse(logics.won())

  @Test def testFirstHit()=
    assertTrue(logics.hit(0, 0).isPresent)