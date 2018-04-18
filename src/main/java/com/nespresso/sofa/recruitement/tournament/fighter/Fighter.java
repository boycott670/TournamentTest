package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.ArrayList;
import java.util.Collection;

import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public abstract class Fighter
{
  private int hp;
  private final Weapon weapon;
  private final Collection<Equipment> equipments;

  Fighter(final int hp, final Weapon weapon)
  {
    this.hp = hp;
    this.weapon = weapon;
    equipments = new ArrayList<>();
  }

  public final Fighter equip(final String equipment)
  {
    return this;
  }

  private final int damage()
  {
    return weapon.damage();
  }

  private static void enagage(final Fighter fighter1, final Fighter fighter2)
  {
    int fighter1Damage = fighter1.damage();
    
    for (final Equipment fighter2Equipment : fighter2.equipments)
    {
      fighter1Damage = fighter2Equipment.whenDamageDealt(fighter1Damage);
    }
    
    if (fighter1Damage > 0)
    {
      fighter2.hp -= fighter1Damage;
      
      if (fighter2.hp < 0)
      {
        fighter2.hp = 0;
      }
    }
  }
  
  public final void engage(final Fighter opponent)
  {
    while (hp > 0 && opponent.hp > 0)
    {
      Fighter.enagage(this, opponent);
      Fighter.enagage(opponent, this);
    }
  }

  public final int hitPoints()
  {
    return hp;
  }
}
