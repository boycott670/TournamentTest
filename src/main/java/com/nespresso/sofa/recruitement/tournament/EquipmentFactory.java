package com.nespresso.sofa.recruitement.tournament;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.equip.Armor;
import com.nespresso.sofa.recruitement.tournament.equip.Buckler;
import com.nespresso.sofa.recruitement.tournament.equip.Equipment;

public final class EquipmentFactory
{
  public static Optional<Equipment> getEquipment(final String equipment)
  {
    final Map<? super String, Supplier<? extends Equipment>> equipmentsSuppliers = new HashMap<>();

    equipmentsSuppliers.put("buckler", Buckler::new);
    equipmentsSuppliers.put("armor", Armor::new);

    return Optional.ofNullable(equipmentsSuppliers.get(equipment))
        .map(Supplier::get);
  }
}
