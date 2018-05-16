package com.nespresso.sofa.recruitement.tournament.parsers;

import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;

public interface EquipmentsParser
{
  Equipment parseEquipment(final String equipment);
}
