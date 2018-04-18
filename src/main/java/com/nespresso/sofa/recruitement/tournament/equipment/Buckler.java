package com.nespresso.sofa.recruitement.tournament.equipment;

import com.nespresso.sofa.recruitement.tournament.weapon.OneHandAxe;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class Buckler extends Equipment
{
  private int dealt = 0;
  private int dealtWithAxe = 0;

  @Override
  public int whenDamageDealt(int damage, Class<? extends Weapon> weaponType)
  {
    if (dealtWithAxe < 3)
    {
      if (dealt++ % 2 == 0)
      {
        if (OneHandAxe.class == weaponType)
        {
          dealtWithAxe++;
        }

        return 0;
      } else
      {
        return damage;
      }
    } else
    {
      return damage;
    }
  }

}
