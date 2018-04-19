package com.nespresso.sofa.recruitement.tournament.equip;

import com.nespresso.sofa.recruitement.tournament.weapon.OneHandAxe;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class Buckler extends Equipment
{

  private int receivedDamageCounter = 0;
  private int receivedDamageByAxeCounter = 0;

  @Override
  public int whenDealingDamage(int currentDamage, Class<? extends Weapon> weaponType)
  {
    return currentDamage;
  }

  @Override
  public int whenReceivingDamage(int currentDamage, Class<? extends Weapon> weaponType)
  {
    if (canCancelReceivedDamage())
    {
      if (OneHandAxe.class == weaponType)
      {
        receivedDamageByAxeCounter++;
      }

      return 0;
    }

    return currentDamage;
  }

  private boolean canCancelReceivedDamage()
  {
    return receivedDamageByAxeCounter < 3 && receivedDamageCounter++ % 2 == 0;
  }

}
