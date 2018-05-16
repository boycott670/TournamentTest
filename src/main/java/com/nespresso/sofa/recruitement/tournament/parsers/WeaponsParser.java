package com.nespresso.sofa.recruitement.tournament.parsers;

import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public interface WeaponsParser
{
  Weapon parseWeapon(final String weapon);
  
  boolean isWeapon(final String equipment);
}
