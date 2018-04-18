package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.ArrayList;
import java.util.Collection;

import com.nespresso.sofa.recruitement.tournament.EquipmentFactory;
import com.nespresso.sofa.recruitement.tournament.equipment.Armor;
import com.nespresso.sofa.recruitement.tournament.equipment.Equipment;
import com.nespresso.sofa.recruitement.tournament.weapon.OneHandAxe;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public abstract class Fighter<F extends Fighter<F>>
{
  private int hp;
  private Weapon weapon;
  private final Collection<Equipment> equipments;

  Fighter(final int hp, final Weapon weapon)
  {
    this.hp = hp;
    this.weapon = weapon;
    equipments = new ArrayList<>();
  }

  public final F equip(final String equipment)
  {
    if ("axe".equals(equipment))
    {
      weapon.wrap(new OneHandAxe());
    } else
    {
      equipments.add(EquipmentFactory.getEquipment(equipment));
    }

    @SuppressWarnings("unchecked")
    final F subFighter = (F) this;

    return subFighter;
  }

  int damage()
  {
    int damage = weapon.damage();

    if (equipments.stream()
        .map(Object::getClass)
        .anyMatch(Armor.class::equals))
    {
      damage--;
    }

    return damage;
  }

  private static void enagage(final Fighter<?> fighter1, final Fighter<?> fighter2)
  {
    int fighter1Damage = fighter1.damage();

    if (fighter1Damage > 0)
    {
      for (final Equipment fighter2Equipment : fighter2.equipments)
      {
        fighter1Damage = fighter2Equipment.whenDamageDealt(fighter1Damage, fighter1.weapon.getClass());

        if (fighter1Damage <= 0)
        {
          break;
        }
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
  }

  public final void engage(final Fighter<?> opponent)
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
