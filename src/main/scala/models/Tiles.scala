package models


case class Tile(entranceList:Set[(Int, Int)]) {


  //how do these things rotate
  //+2 under mod for all permutations
  def rotate():Tile = Tile(entranceList
    .map(a => ((a._1 + 1) % 8 + 1, (a._2 + 1) % 8 + 1))
    .map(a => if(a._1 > a._2) (a._2, a._1) else a))

  override def equals(obj: Any): Boolean = obj match {
    case t:Tile => isARotation(t)
    case _ => false
  }

  def isARotation(tile: Tile): Boolean = {
    List(tile.entranceList,
      tile.rotate().entranceList,
      tile.rotate().rotate().entranceList,
      tile.rotate().rotate().rotate().entranceList) contains entranceList
  }

  override def hashCode: Int = 1

}

object Tiles extends App {

  val everyCard: Seq[Tile] = List(1,2,3,4,5,6,7,8)
    .permutations.toList
    .map(n => n.grouped(2).map{
      case List(a, b) => (a, b)
    }.toSet)
    .filter(_.forall(x => x._1 < x._2))
    .map(Tile)
    .distinct

  println(everyCard)
  println(everyCard.length)

}
