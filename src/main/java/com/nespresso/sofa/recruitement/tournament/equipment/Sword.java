package com.nespresso.sofa.recruitement.tournament.equipment;

import java.util.function.ToIntFunction;

public final class Sword extends Equipment
{
  
  private static final int DAMAGE = 5;

  @Override
  ToIntFunction<Class<? extends Equipment>> damageIncreaseWhenDealingDamage()
  {
    return weaponType -> DAMAGE;
  }

  @Override
  ToIntFunction<Class<? extends Equipment>> damageDecreaseWhenReceivingDamage()
  {
    return weaponType -> 0;
  }

}
