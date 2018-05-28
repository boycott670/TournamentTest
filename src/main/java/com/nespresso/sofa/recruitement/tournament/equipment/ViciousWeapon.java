package com.nespresso.sofa.recruitement.tournament.equipment;

import java.util.function.ToIntFunction;

public final class ViciousWeapon extends Equipment
{

  private static final int POISON_DAMAGE = 20;

  private final Equipment wrappedWeapon;

  private int damageCounter = 0;

  public ViciousWeapon(final Equipment weapon)
  {
    wrappedWeapon = weapon;
  }
  
  private boolean isPoisonous()
  {
    return damageCounter < 2;
  }

  @Override
  ToIntFunction<Class<? extends Equipment>> damageIncreaseWhenDealingDamage()
  {
    return weaponType -> wrappedWeapon.damageIncrease(weaponType) + (isPoisonous() ? POISON_DAMAGE : 0);
  }

  @Override
  ToIntFunction<Class<? extends Equipment>> damageDecreaseWhenReceivingDamage()
  {
    return weaponType -> 0;
  }

  @Override
  public Runnable damageReceivedHook()
  {
    return () ->
    {
      damageCounter++;
    };
  }

}
