package com.nespresso.sofa.recruitement.tournament.weapon;

public abstract class Weapon
{
  private boolean isPoisonous = false;
  private int damageCount = 0;

  abstract int baseDamage();

  public final void poison()
  {
    isPoisonous = true;
  }

  private boolean canPoison()
  {
    return damageCount++ < 2 && isPoisonous;
  }

  public final int damage()
  {
    return baseDamage() + (canPoison() ? 20 : 0);
  }

  public final Weapon switchTo(final Weapon otherWeapon)
  {
    if (isPoisonous)
    {
      otherWeapon.poison();
    }

    return otherWeapon;
  }
}
