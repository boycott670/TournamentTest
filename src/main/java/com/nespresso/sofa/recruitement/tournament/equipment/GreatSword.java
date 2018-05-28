package com.nespresso.sofa.recruitement.tournament.equipment;

import java.util.function.ToIntFunction;

public final class GreatSword extends Equipment
{
  
  private static final int DAMAGE = 12;
  
  private int damageCounter = 0;
  
  private boolean isEffective()
  {
    return damageCounter % 3 < 2;
  }

  @Override
  ToIntFunction<Class<? extends Equipment>> damageIncreaseWhenDealingDamage()
  {
    return weaponType -> isEffective() ? DAMAGE : 0;
  }

  @Override
  ToIntFunction<Class<? extends Equipment>> damageDecreaseWhenReceivingDamage()
  {
    return weaponType -> 0;
  }

  @Override
	public Runnable damageDealtHook()
	{
		return () ->
		{
			damageCounter++;
		};
	}

}
