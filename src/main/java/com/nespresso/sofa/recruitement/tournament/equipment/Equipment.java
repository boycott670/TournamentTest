package com.nespresso.sofa.recruitement.tournament.equipment;

import java.util.function.ToIntFunction;

public abstract class Equipment
{
  private static final Runnable NOOP_POST_ENGAGE_HOOK = () -> {};
  
  abstract ToIntFunction<Class<? extends Equipment>> damageIncreaseWhenDealingDamage();

  abstract ToIntFunction<Class<? extends Equipment>> damageDecreaseWhenReceivingDamage();
  
  public Runnable postEngageHook()
  {
    return NOOP_POST_ENGAGE_HOOK;
  }
  
  public final int damageIncrease(final Class<? extends Equipment> weaponType)
  {
    return damageIncreaseWhenDealingDamage().applyAsInt(weaponType);
  }
  
  public final int damageDecrease(final Class<? extends Equipment> weaponType)
  {
    return damageDecreaseWhenReceivingDamage().applyAsInt(weaponType);
  }
}
