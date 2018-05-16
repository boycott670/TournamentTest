package com.nespresso.sofa.recruitement.tournament.parsers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.weapon.Axe;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class DefaultWeaponsParser implements WeaponsParser
{
  
  private static final Map<String, Supplier<? extends Weapon>> WEAPONS_MAPPING = new HashMap<String, Supplier<? extends Weapon>>()
  {
    private static final long serialVersionUID = -7924014304255083311L;

    {
      put("axe", Axe::new);
    }
  };

  @Override
  public Weapon parseWeapon(String weapon)
  {
    return WEAPONS_MAPPING.get(weapon).get();
  }

  @Override
  public boolean isWeapon(String equipment)
  {
    return WEAPONS_MAPPING.keySet().contains(equipment);
  }

}
