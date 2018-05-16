package com.nespresso.sofa.recruitement.tournament.equipment;

import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public abstract class Equipment
{
  public abstract int reduceDamage(final int damage, final Class<? extends Weapon> weaponType);
}
