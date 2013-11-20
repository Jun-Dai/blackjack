package net.kobashigawa.blackjack

import scala.util.Random

trait GameDef {

  sealed abstract class Suit(val name: String)
  case object Spade    extends Suit("\u2660")
  case object Hearts   extends Suit("\u2665")
  case object Diamonds extends Suit("\u2666")
  case object Clubs    extends Suit("\u2663")

  class Rank(val abbr: String)
  class HardRank(override val abbr: String, val value: Integer) extends Rank(abbr)
  class NumericRank(override val value: Integer) extends HardRank(value.toString, value)
  class FaceRank(override val abbr: String) extends HardRank(abbr, 10)

  case object Two extends NumericRank(2)
  case object Three extends NumericRank(3)
  case object Four extends NumericRank(4)
  case object Five extends NumericRank(5)
  case object Six extends NumericRank(6)
  case object Seven extends NumericRank(7)
  case object Eight extends NumericRank(8)
  case object Nine extends NumericRank(9)
  case object Ten extends HardRank("T", 10)
  case object Jack extends FaceRank("J")
  case object Queen extends FaceRank("Q")
  case object King extends FaceRank("K")
  case object Ace extends Rank("A")

  sealed abstract class Action
  case object Hit extends Action
  case object Stay extends Action
  case object Double extends Action
  case object Split extends Action

  val allSuits = List(Spade, Hearts, Diamonds, Clubs)
  val allRanks = List(Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace)

  case class Card(rank: Rank, suit: Suit)

  type Deck = List[Card]
  type Hand = List[Card]


  def to_s(card: Card): String = s"${card.rank.abbr}${card.suit.name}"

  def to_s(deck: Deck): String = deck.collect { case c => to_s(c) }.mkString("\n")

  def shuffledDeck(): List[Card] = {
    Random.shuffle(allSuits.map {
      suit => allRanks.map {
        rank => Card(rank, suit)
      }
    }.flatten)
  }
}



