package com.nespresso.sofa.recruitement.tournament.fighter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.EquipmentDamageEvent;
import com.nespresso.sofa.recruitement.tournament.EquipmentFactory;
import com.nespresso.sofa.recruitement.tournament.WeaponFactory;
import com.nespresso.sofa.recruitement.tournament.equip.Equipment;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public abstract class Fighter<F extends Fighter<F>>
{
  private int hp;
  private Weapon weapon;
  private final Collection<Equipment> equipments;

  Fighter(int hp, Weapon weapon)
  {
    this(hp, weapon, false);
  }
  
  Fighter(int hp, Weapon weapon, boolean isPoisonedWeapon)
  {
    this.hp = hp;
    this.weapon = weapon;
    
    if (isPoisonedWeapon)
    {
      this.weapon.poison();
    }

    equipments = new ArrayList<>();
  }

  public final int hitPoints()
  {
    return Math.max(0, hp);
  }

  public final F equip(final String weaponOrEquipment)
  {
    final Optional<? extends Weapon> optionalWeapon = WeaponFactory.getWeapon(weaponOrEquipment);
    final Optional<? extends Equipment> optionalEquipment = EquipmentFactory.getEquipment(weaponOrEquipment);

    if (!optionalWeapon.isPresent() && !optionalEquipment.isPresent())
    {
      throw new IllegalArgumentException();
    }
    else if (optionalWeapon.isPresent())
    {
      weapon = weapon.switchTo(optionalWeapon.get());
    }
    else
    {
      equipments.add(optionalEquipment.get());
    }

    @SuppressWarnings("unchecked")
    final F effectiveThis = (F) this;

    return effectiveThis;
  }
  
  private boolean isAlive()
  {
    return hitPoints() > 0;
  }

  private int damageCalculator(final int initialDamage, final EquipmentDamageEvent event, final Class<? extends Weapon> weaponType)
  {
    int damage = initialDamage;
    
    if (damage > 0)
    {
      for (final Equipment equipment : equipments)
      {
        damage = event.fire(equipment, damage, weaponType);
        
        if (damage <= 0)
        {
          return 0;
        }
      }
    }
    
    return damage;
  }
  
  int damage()
  {
    return damageCalculator(weapon.damage(), Equipment::whenDealingDamage, weapon.getClass());
  }
  
  private int receiveBlowFromAttacker(final Fighter<?> attacker)
  {
    return damageCalculator(attacker.damage(), Equipment::whenReceivingDamage, attacker.weapon.getClass());
  }
  
  private static void blow(final Fighter<?> attacker, final Fighter<?> defender)
  {
    defender.hp -= defender.receiveBlowFromAttacker(attacker);
  }
  
  public final void engage(final Fighter<?> opponent)
  {
    final Supplier<? extends Boolean> areBothFightersAlive = () -> isAlive() && opponent.isAlive();
    
    while (areBothFightersAlive.get())
    {
      Fighter.blow(this, opponent);
      
      if (areBothFightersAlive.get())
      {
        Fighter.blow(opponent, this);
      }
    }
  }
}
