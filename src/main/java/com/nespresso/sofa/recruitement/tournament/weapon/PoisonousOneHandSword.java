package com.nespresso.sofa.recruitement.tournament.weapon;

public final class PoisonousOneHandSword extends OneHandSword
{

  private int blows = 0;

  @Override
  public int damage()
  {
    return 6 + (++blows <= 2 ? 20 : 0);
  }

}
