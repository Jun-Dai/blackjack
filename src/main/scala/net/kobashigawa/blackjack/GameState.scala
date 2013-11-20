package net.kobashigawa.blackjack

trait GameState extends GameDef {
  case class GameState(
                   playerBet: Integer,
                   playerHand: Hand,
                   dealerCardShowing: Card,
                   deckUsed: Deck,
                   insurance: Int,
                   playersTurn: Boolean
  )
}
