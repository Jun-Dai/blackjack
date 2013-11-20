package net.kobashigawa.blackjack

object Dealer extends GameDef with GameState {
  private var deck: Deck = shuffledDeck()
  private var hand: Hand = Nil

  def visibleCard(): Card = hand.head
  var usedDeck: Deck = Nil

  def deal(): Hand = {
    if (deck.size < 15) {
      deck = shuffledDeck()
      usedDeck = Nil
    }

    var playerHand: Hand = List()
    hand = List()

    playerHand :+= dealCard
    hand :+= dealCard
    playerHand :+= dealCard
    hand :+= dealCard

    player
  }

  def dealCard(): Card = deck match {
    case head::tail => deck = tail; head
  }

  def handleAction(action: Action): GameState = action match {
    case Hit =>
  }

  def playRound(strategy: Strategy) {
    val initialHand = deal()
    var state = new GameState(strategy.betAmount(usedDeck), initialHand, visibleCard(), usedDeck, 0, true)

    if (visibleCard().rank == Ace) {
      state = state.copy(insurance = strategy.insuranceAmount(state))
    }

    while(state.playersTurn) {
      state = state match {
        case Hit => hit(state)
        case Stay => stay(state)
        case Split => split(state)
        case Double => double(state)
      }
    }
  }
}
