package com.nespresso.sofa.recruitement.tournament.equipment;

import java.util.function.ToIntFunction;

public final class Armor extends Equipment
{

  @Override
  ToIntFunction<Class<? extends Equipment>> damageIncreaseWhenDealingDamage()
  {
    return weaponType -> -1;
  }

  @Override
  ToIntFunction<Class<? extends Equipment>> damageDecreaseWhenReceivingDamage()
  {
    return weaponType -> 3;
  }

  @Override
  public Runnable postEngageHook()
  {
    return super.postEngageHook();
  }

}
