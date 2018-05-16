package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.weapon.Axe;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class Viking extends Fighter<Viking>
{
  private static final int HP = 120;
  
  private static final Supplier<? extends Weapon> DEFAULT_WEAPON = Axe::new;

  public Viking()
  {
    super(HP, DEFAULT_WEAPON.get());
  }
}
