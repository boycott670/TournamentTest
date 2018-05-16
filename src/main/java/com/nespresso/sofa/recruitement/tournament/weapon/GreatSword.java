package com.nespresso.sofa.recruitement.tournament.weapon;

public final class GreatSword extends Weapon
{
  private static final int DAMAGE = 12;
  
  private int damageCounter = 0;

  public GreatSword()
  {
    super(DAMAGE);
  }

  @Override
  public int getDamage()
  {
    if (damageCounter++ % 3 < 2)
    {
      return super.getDamage();
    }
    
    return 0;
  }
}
