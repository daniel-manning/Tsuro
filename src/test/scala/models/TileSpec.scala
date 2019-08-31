package models

import org.scalatest.{Matchers, WordSpec}

class TileSpec extends WordSpec with Matchers {

  val northTile = Tile(Set((1,8), (2,5), (3, 7), (4, 6)))
  val eastTile = Tile(Set((1,5), (2,3), (4, 7), (6, 8)))

  "A Tile" when {
    "rotated" should {
      "be equal to each of it's rotations" in {
        northTile.rotate() shouldBe eastTile
      }

    }

    "checked with one of it's rotations" should {
      "be equal" in {
        northTile.isARotation(eastTile) shouldBe true
      }
    }
  }
}
