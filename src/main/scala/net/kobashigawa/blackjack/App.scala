package net.kobashigawa.blackjack

object App extends GameDef {
  def main(args : Array[String]) {
    println(to_s(shuffledDeck()))
  }
}