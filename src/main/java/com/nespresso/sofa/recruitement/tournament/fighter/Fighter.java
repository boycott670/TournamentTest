package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.equipment.Buckler;
import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;
import com.nespresso.sofa.recruitement.tournament.strategies.DefaultEngagementStrategy;
import com.nespresso.sofa.recruitement.tournament.strategies.EngagementStrategy;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public abstract class Fighter<F extends Fighter<F>>
{
  private static final Map<String, Supplier<? extends Equipment>> EQUIPMENTS_MAPPING = new HashMap<String, Supplier<? extends Equipment>>()
  {
    private static final long serialVersionUID = 2598800111752342597L;

    {
      put("buckler", Buckler::new);
    }
  };
  
  private final EngagementStrategy engagementStrategy;
  
  private int hp;
  private final Weapon weapon;
  
  private final Collection<Equipment> equipments;
  
  Fighter(int hp, Weapon weapon)
  {
    engagementStrategy = new DefaultEngagementStrategy();
    
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
    equipments.add(EQUIPMENTS_MAPPING.get(equipment).get());

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
