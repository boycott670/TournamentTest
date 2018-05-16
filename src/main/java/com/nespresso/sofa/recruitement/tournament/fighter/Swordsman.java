package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.weapon.Sword;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class Swordsman extends Fighter
{
  private static final int HP = 100;
  
  private static final Supplier<? extends Weapon> DEFAULT_WEAPON = Sword::new;

  public Swordsman()
  {
    super(HP, DEFAULT_WEAPON.get());
  }
}
