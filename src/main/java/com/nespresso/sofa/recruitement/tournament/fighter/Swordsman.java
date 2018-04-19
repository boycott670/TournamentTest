package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.weapon.OneHandSword;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class Swordsman extends Fighter<Swordsman>
{
  private static final int INITIAL_HP = 100;
  private static final Supplier<? extends Weapon> DEFAULT_WEAPON = OneHandSword::new;

  public Swordsman()
  {
    super(INITIAL_HP, DEFAULT_WEAPON.get());
  }

  public Swordsman(final String vicious)
  {
    super(INITIAL_HP, DEFAULT_WEAPON.get(), true);
  }
}
