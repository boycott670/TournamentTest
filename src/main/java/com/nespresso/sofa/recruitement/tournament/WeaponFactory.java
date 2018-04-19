package com.nespresso.sofa.recruitement.tournament;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import com.nespresso.sofa.recruitement.tournament.weapon.OneHandAxe;
import com.nespresso.sofa.recruitement.tournament.weapon.Weapon;

public final class WeaponFactory
{
  public static Optional<Weapon> getWeapon(final String weapon)
  {
    final Map<? super String, Supplier<? extends Weapon>> weaponsSuppliers = new HashMap<>();

    weaponsSuppliers.put("axe", OneHandAxe::new);

    return Optional.ofNullable(weaponsSuppliers.get(weapon))
        .map(Supplier::get);
  }
}
