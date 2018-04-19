package com.nespresso.sofa.recruitement.tournament.equip;

import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class Armor extends Equipment
{

  @Override
  public int whenDealingDamage(int currentDamage, Class<? extends Weapon> weaponType)
  {
    return currentDamage - 1;
  }

  @Override
  public int whenReceivingDamage(int currentDamage, Class<? extends Weapon> weaponType)
  {
    return currentDamage - 3;
  }

}
