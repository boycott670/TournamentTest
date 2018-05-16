package com.nespresso.sofa.recruitement.tournament.strategies;

import java.util.function.BiConsumer;

import com.nespresso.sofa.recruitement.tournament.fighter.Fighter;

public final class DefaultEngagementStrategy implements EngagementStrategy
{
  
  private Fighter firstFighter;
  
  private Fighter secondFighter;

  @Override
  public void setFirstFighter(Fighter fighter)
  {
    firstFighter = fighter;
  }

  @Override
  public void setSecondFighter(Fighter fighter)
  {
    secondFighter = fighter;
  }

  @Override
  public void engage()
  {
    final BiConsumer<Fighter, Fighter> attack = (attacker, defender) -> defender.setHitPoints(Math.max(0, defender.hitPoints() - attacker.getWeapon().getDamage()));
    
    while(firstFighter.hitPoints() > 0 && secondFighter.hitPoints() > 0)
    {
      attack.accept(firstFighter, secondFighter);
      
      if (secondFighter.hitPoints() > 0)
      {
        attack.accept(secondFighter, firstFighter);
      }
    }
  }

}
