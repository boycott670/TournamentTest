package com.nespresso.sofa.recruitement.tournament.weapon;

public final class GreatSword extends Weapon
{
  private int damageCounter = -1;

  @Override
  public int damage()
  {
    damageCounter++;

    if (damageCounter % 3 <= 1)
    {
      return 12;
    } else
    {
      return 0;
    }
  }

}
