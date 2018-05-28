package com.nespresso.sofa.recruitement.tournament.parsers;

import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;

public interface EquipmentsParser
{
  void setEquipment(final String equipment);
  
  Equipment parseEquipment();
}
