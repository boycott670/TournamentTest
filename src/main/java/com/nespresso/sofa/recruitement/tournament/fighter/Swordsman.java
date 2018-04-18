package com.nespresso.sofa.recruitement.tournament.fighter;

import com.nespresso.sofa.recruitement.tournament.weapon.OneHandSword;

public final class Swordsman extends Fighter<Swordsman>
{
  private boolean isVicious = false;
  private int damageCount = 0;

  public Swordsman()
  {
    super(100, new OneHandSword());
  }

  public Swordsman(final String vicious)
  {
    this();
    isVicious = true;
  }

  @Override
  int damage()
  {
    return super.damage() + (++damageCount <= 2 && isVicious ? 20 : 0);
  }
}
