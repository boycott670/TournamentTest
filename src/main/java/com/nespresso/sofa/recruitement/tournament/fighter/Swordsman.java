package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;
import com.nespresso.sofa.recruitement.tournament.equipment.Sword;

public final class Swordsman extends Fighter<Swordsman>
{
  private static final int INITIAL_HP = 100;
  
  private boolean isVicious = false;
  
  public Swordsman()
  {
    super(INITIAL_HP);
  }
  
  public Swordsman(final String vicious)
  {
    this();
    
    isVicious = true;
  }

  @Override
  Swordsman effectiveThis()
  {
    return this;
  }

  @Override
  Supplier<? extends Equipment> defaultWeaponSupplier()
  {
    return Sword::new;
  }

  @Override
  boolean isVicious()
  {
    return isVicious;
  }
}
