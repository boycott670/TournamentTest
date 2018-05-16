package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.weapon.GreatSword;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class Highlander extends Fighter<Highlander>
{
  private static final int HP = 150;
  
  private static final Supplier<? extends Weapon> DEFAULT_WEAPON = GreatSword::new;
  
  private boolean isVeteran = false;

  public Highlander()
  {
    super(HP, DEFAULT_WEAPON.get());
  }
  
  public Highlander(final String veteran)
  {
    this();
    
    isVeteran = true;
  }

  @Override
  public void takenDamage()
  {
    if (isVeteran && hitPoints() < HP * .3)
    {
      getWeapon().berserk();
    }
  }
}
