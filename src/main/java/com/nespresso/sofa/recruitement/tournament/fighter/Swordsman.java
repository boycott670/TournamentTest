package com.nespresso.sofa.recruitement.tournament.fighter;

import com.nespresso.sofa.recruitement.tournament.weapon.OneHandSword;
import com.nespresso.sofa.recruitement.tournament.weapon.PoisonousOneHandSword;

public final class Swordsman extends Fighter<Swordsman>
{
  public Swordsman()
  {
    super(100, new OneHandSword());
  }

  public Swordsman(final String vicious)
  {
    super(100, new PoisonousOneHandSword());
  }
}
