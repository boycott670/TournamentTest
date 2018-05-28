package com.nespresso.sofa.recruitement.tournament.parsers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.equipment.Armor;
import com.nespresso.sofa.recruitement.tournament.equipment.Axe;
import com.nespresso.sofa.recruitement.tournament.equipment.Buckler;
import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;

public final class DefaultEquipmentsParser implements EquipmentsParser
{
  
  private static final Map<String, Supplier<? extends Equipment>> EQUIPMENTS_MAPPING = new HashMap<String, Supplier<? extends Equipment>>()
  {
    private static final long serialVersionUID = -285410214699884380L;

    {
      put("buckler", Buckler::new);
      put("armor", Armor::new);
      put("axe", Axe::new);
    }
  };
  
  private String equipmentToParse;

  @Override
  public void setEquipment(String equipment)
  {
    equipmentToParse = equipment;
  }

  @Override
  public Equipment parseEquipment()
  {
    return EQUIPMENTS_MAPPING.get(equipmentToParse).get();
  }

}
