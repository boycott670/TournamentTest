package com.nespresso.sofa.recruitement.tournament.equipment;

import java.util.function.ToIntFunction;

public abstract class Equipment
{
  private static final Runnable NOOP_HOOK = () -> {};
  
  abstract ToIntFunction<Class<? extends Equipment>> damageIncreaseWhenDealingDamage();

  abstract ToIntFunction<Class<? extends Equipment>> damageDecreaseWhenReceivingDamage();
  
  public Runnable damageReceivedHook()
  {
    return NOOP_HOOK;
  }
  
  public Runnable damageDealtHook()
  {
    return NOOP_HOOK;
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
