package com.nespresso.sofa.recruitement.tournament.weapon;

public abstract class Weapon
{
  private static final int POISON_DAMAGE = 20;
  private final int damage;
  
  private int poisonDamageCounter = 0;
  
  private boolean poisonous = false;
  
  private boolean isBerserk = false;

  Weapon(int damage)
  {
    this.damage = damage;
  }

  public int getDamage()
  {
    return (damage + (poisonous ? (poisonDamageCounter++ < 2 ? POISON_DAMAGE : 0) : 0)) * (isBerserk ? 2 : 1);
  }
  
  public void poison()
  {
    poisonous = true;
  }
  
  public void berserk()
  {
    isBerserk = true;
  }
  
  public Weapon switchTo(final Weapon weapon)
  {
    if (poisonous)
    {
      weapon.poison();
    }
    
    if (isBerserk)
    {
      weapon.berserk();
    }
    
    return weapon;
  }
}
