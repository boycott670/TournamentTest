package com.nespresso.sofa.recruitement.tournament.fighter;

import com.nespresso.sofa.recruitement.tournament.weapon.OneHandSword;

public final class Swordsman extends Fighter<Swordsman>
{
  public Swordsman()
  {
    super(100, new OneHandSword());
  }
}
