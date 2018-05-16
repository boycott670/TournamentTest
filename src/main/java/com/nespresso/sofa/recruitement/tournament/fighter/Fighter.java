package com.nespresso.sofa.recruitement.tournament.fighter;

import com.nespresso.sofa.recruitement.tournament.strategies.DefaultEngagementStrategy;
import com.nespresso.sofa.recruitement.tournament.strategies.EngagementStrategy;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public abstract class Fighter
{
  private final EngagementStrategy engagementStrategy;
  
  private int hp;
  private final Weapon weapon;
  
  Fighter(int hp, Weapon weapon)
  {
    this.hp = hp;
    this.weapon = weapon;
    
    engagementStrategy = new DefaultEngagementStrategy();
  }

  public void setHitPoints(int hp)
  {
    this.hp = hp;
  }

  public Weapon getWeapon()
  {
    return weapon;
  }
  
  public int hitPoints()
  {
    return hp;
  }
  
  public void engage(final Fighter opponent)
  {
    engagementStrategy.setFirstFighter(this);
    engagementStrategy.setSecondFighter(opponent);
    
    engagementStrategy.engage();
  }
}
