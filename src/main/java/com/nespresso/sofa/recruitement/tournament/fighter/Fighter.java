package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;
import com.nespresso.sofa.recruitement.tournament.equipment.ViciousWeapon;
import com.nespresso.sofa.recruitement.tournament.parsers.DefaultEquipmentsParser;
import com.nespresso.sofa.recruitement.tournament.parsers.EquipmentsParser;

public abstract class Fighter<F extends Fighter<F>>
{
  private final EquipmentsParser equipmentsParser;

  private int hitPoints;

  private final Deque<Equipment> equipments;
  
  private final Equipment weapon;

  Fighter(int hitPoints)
  {
    equipmentsParser = new DefaultEquipmentsParser();

    this.hitPoints = hitPoints;

    equipments = new ArrayDeque<>();
    
    weapon = defaultWeaponSupplier().get();
  }
  
  abstract F effectiveThis();

  abstract Supplier<? extends Equipment> defaultWeaponSupplier();

  boolean isVicious()
  {
    return false;
  }
  
  int damageBoostFactor()
  {
    return 1;
  }

  public final int hitPoints()
  {
    return Math.max(0, hitPoints);
  }

  public final F equip(final String equipment)
  {
    equipmentsParser.setEquipment(equipment);

    equipments.add(equipmentsParser.parseEquipment());

    return effectiveThis();
  }
  
  private boolean isAlive()
  {
    return hitPoints() > 0;
  }
  
  private void blow(final Fighter<?> opponent)
  {
     final Class<? extends Equipment> weaponType = weapon.getClass();
     
    int damage = equipments
        .stream()
        .mapToInt(equipment -> equipment.damageIncrease(weaponType))
        .sum();
    
    damage *= damageBoostFactor();
    
    for (final Equipment defensiveEquipment : opponent.equipments)
    {
       damage -= defensiveEquipment.damageDecrease(weaponType);
       
       defensiveEquipment.postEngageHook().run();
       
       if (damage <= 0)
       {
         return;
       }
    }
    
    opponent.hitPoints -= damage;
  }
  
  private void addWeaponToArsenal()
  {
    if (isVicious())
    {
      equipments.addFirst(new ViciousWeapon(equipments.removeFirst()));
    }
    else
    {
      equipments.addFirst(weapon);
    }
  }
  
  public final void engage(final Fighter<?> opponent)
  {
    addWeaponToArsenal();
    
    opponent.addWeaponToArsenal();
    
    while(isAlive() && opponent.isAlive())
    {
      blow(opponent);
      
      if (opponent.isAlive())
      {
        opponent.blow(this);
      }
    }
  }
}
