package com.nespresso.sofa.recruitement.tournament.weapon;

public final class ViciousWeapon extends Weapon
{
  private Weapon rawWeapon;
  private int damageCount = 0;

  public ViciousWeapon(Weapon rawWeapon)
  {
    this.rawWeapon = rawWeapon;
  }

  @Override
  public int damage()
  {
    return rawWeapon.damage() + (++damageCount <= 2 ? 20 : 0);
  }

  @Override
  public void wrap(Weapon otherWeapon)
  {
    rawWeapon = otherWeapon;
  }
}
