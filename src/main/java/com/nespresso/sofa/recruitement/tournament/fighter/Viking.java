package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.weapon.OneHandAxe;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class Viking extends Fighter<Viking>
{
  private static final int INITIAL_HP = 120;
  private static final Supplier<? extends Weapon> DEFAULT_WEAPON = OneHandAxe::new;

  public Viking()
  {
    super(INITIAL_HP, DEFAULT_WEAPON.get());
  }
}
