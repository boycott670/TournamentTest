package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.equipment.Axe;
import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;

public final class Viking extends Fighter<Viking>
{
  
  private static final int INITIAL_HP = 120;

  public Viking()
  {
    super(INITIAL_HP);
  }

  @Override
  Viking effectiveThis()
  {
    return this;
  }

  @Override
  Supplier<? extends Equipment> defaultWeaponSupplier()
  {
    return Axe::new;
  }

}
