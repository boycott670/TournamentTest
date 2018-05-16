package com.nespresso.sofa.recruitement.tournament.equipment;

import com.nespresso.sofa.recruitement.tournament.weapon.Axe;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class Buckler extends Equipment
{
  
  private int reduceDamageCounter = 0;
  private int reduceDamageFromAxeCounter = 0;

  @Override
  public int reduceDamage(int damage, Class<? extends Weapon> weaponType)
  {
    if (reduceDamageFromAxeCounter >= 3)
    {
      return damage;
    }
    
    if (reduceDamageCounter++ % 2 != 0)
    {
      return damage;
    }
    
    if (weaponType == Axe.class)
    {
      reduceDamageFromAxeCounter++;
    }
    
    return 0;
  }

}
