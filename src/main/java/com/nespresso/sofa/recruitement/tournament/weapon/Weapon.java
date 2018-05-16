package com.nespresso.sofa.recruitement.tournament.weapon;

public abstract class Weapon
{
  private final int damage;

  Weapon(int damage)
  {
    this.damage = damage;
  }

  public int getDamage()
  {
    return damage;
  }
}
