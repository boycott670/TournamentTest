package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.weapon.GreatSword;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class Highlander extends Fighter<Highlander>
{
  private static final int HP = 150;
  
  private static final Supplier<? extends Weapon> DEFAULT_WEAPON = GreatSword::new;

  public Highlander()
  {
    super(HP, DEFAULT_WEAPON.get());
  }
}
