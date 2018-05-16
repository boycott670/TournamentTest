package com.nespresso.sofa.recruitement.tournament.parsers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.equipment.Armor;
import com.nespresso.sofa.recruitement.tournament.equipment.Buckler;
import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;

public final class DefaultEquipmentsParser implements EquipmentsParser
{
  private static final Map<String, Supplier<? extends Equipment>> EQUIPMENTS_MAPPING = new HashMap<String, Supplier<? extends Equipment>>()
  {
    private static final long serialVersionUID = 2598800111752342597L;

    {
      put("buckler", Buckler::new);
      
      put("armor", Armor::new);
    }
  };

  @Override
  public Equipment parseEquipment(String equipment)
  {
    return EQUIPMENTS_MAPPING.get(equipment).get();
  }

}
