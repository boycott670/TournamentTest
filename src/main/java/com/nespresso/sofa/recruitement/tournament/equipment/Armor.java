package com.nespresso.sofa.recruitement.tournament.equipment;

import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class Armor extends Equipment
{

  @Override
  public int reduceDamage(int damage, Class<? extends Weapon> weaponType)
  {
    return damage - 3;
  }

  @Override
  public int reduceOwnDamage(int damage)
  {
    return damage - 1;
  }

}
