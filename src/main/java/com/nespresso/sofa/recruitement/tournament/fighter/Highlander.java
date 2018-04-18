package com.nespresso.sofa.recruitement.tournament.fighter;

import com.nespresso.sofa.recruitement.tournament.weapon.GreatSword;

public final class Highlander extends Fighter<Highlander>
{
  private final double initialHp;
  private boolean isVeteran = false;

  public Highlander()
  {
    super(150, new GreatSword());
    initialHp = hitPoints();
  }

  public Highlander(final String veteran)
  {
    this();
    isVeteran = true;
  }

  @Override
  int damage()
  {
    int damage = super.damage();

    if (isVeteran && hitPoints() / initialHp < .3)
    {
      damage *= 2;
    }

    return damage;
  }
}
