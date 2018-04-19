package com.nespresso.sofa.recruitement.tournament;

import com.nespresso.sofa.recruitement.tournament.equip.Equipment;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

@FunctionalInterface
public interface EquipmentDamageEvent
{
  int fire(Equipment equipment, int currentDamage, Class<? extends Weapon> weaponType);
}
