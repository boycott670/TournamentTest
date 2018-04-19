package com.nespresso.sofa.recruitement.tournament.weapon;

public final class GreatSword extends Weapon
{

  private static final int DAMAGE = 12;

  private int damageCount = 0;

  @Override
  public int baseDamage()
  {
    return canDamage() ? DAMAGE : 0;
  }

  private boolean canDamage()
  {
    return damageCount++ % 3 <= 1;
  }

}
