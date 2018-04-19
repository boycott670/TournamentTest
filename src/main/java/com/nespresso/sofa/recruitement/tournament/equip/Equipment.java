package com.nespresso.sofa.recruitement.tournament.equip;

import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public abstract class Equipment
{
  public abstract int whenDealingDamage(final int currentDamage, final Class<? extends Weapon> weaponType);

  public abstract int whenReceivingDamage(final int currentDamage, final Class<? extends Weapon> weaponType);
}
