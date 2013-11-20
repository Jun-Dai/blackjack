package net.kobashigawa.blackjack

abstract class Strategy extends GameDef {
  def action(gameState: GameState): Action

  def insuranceAmount(gameState: GameState): Int

  def betAmount(deckUsed: Deck): Integer
}
