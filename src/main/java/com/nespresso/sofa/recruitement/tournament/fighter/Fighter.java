package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.ArrayList;
import java.util.Collection;

import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;
import com.nespresso.sofa.recruitement.tournament.parsers.DefaultEquipmentsParser;
import com.nespresso.sofa.recruitement.tournament.parsers.EquipmentsParser;
import com.nespresso.sofa.recruitement.tournament.strategies.DefaultEngagementStrategy;
import com.nespresso.sofa.recruitement.tournament.strategies.EngagementStrategy;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public abstract class Fighter<F extends Fighter<F>>
{
  private final EngagementStrategy engagementStrategy;
  
  private final EquipmentsParser equipmentsParser;
  
  private int hp;
  private final Weapon weapon;
  
  private final Collection<Equipment> equipments;
  
  Fighter(int hp, Weapon weapon)
  {
    engagementStrategy = new DefaultEngagementStrategy();
    
    equipmentsParser = new DefaultEquipmentsParser();
    
    this.hp = hp;
    this.weapon = weapon;
    
    equipments = new ArrayList<>();
  }
  
  public int hitPoints()
  {
    return hp;
  }

  public void setHitPoints(int hp)
  {
    this.hp = hp;
  }

  public Weapon getWeapon()
  {
    return weapon;
  }
  
  public Collection<Equipment> getEquipments()
  {
    return equipments;
  }

  public F equip(final String equipment)
  {
    equipments.add(equipmentsParser.parseEquipment(equipment));

    @SuppressWarnings("unchecked")
    final F effetiveThis = (F)this;
    
    return effetiveThis;
  }
  
  public void engage(final Fighter<?> opponent)
  {
    engagementStrategy.setFirstFighter(this);
    engagementStrategy.setSecondFighter(opponent);
    
    engagementStrategy.engage();
  }
}
