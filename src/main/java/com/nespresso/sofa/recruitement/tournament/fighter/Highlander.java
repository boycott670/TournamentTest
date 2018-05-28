package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;
import com.nespresso.sofa.recruitement.tournament.equipment.GreatSword;

public final class Highlander extends Fighter<Highlander>
{

  private static final int INITIAL_HP = 150;

  private boolean isVeteran = false;

  public Highlander()
  {
    super(INITIAL_HP);
  }

  public Highlander(final String veteran)
  {
    this();
    
    isVeteran = true;
  }

  @Override
  Highlander effectiveThis()
  {
    return this;
  }

  @Override
  Supplier<? extends Equipment> defaultWeaponSupplier()
  {
    return GreatSword::new;
  }

  private boolean canDoubleDamage()
  {
    return isVeteran && (double)hitPoints() / INITIAL_HP < .3;
  }

  @Override
  int damageBoostFactor()
  {
    return canDoubleDamage() ? 2 : super.damageBoostFactor();
  }

}
