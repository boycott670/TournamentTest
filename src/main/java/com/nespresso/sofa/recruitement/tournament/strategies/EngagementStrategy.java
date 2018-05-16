package com.nespresso.sofa.recruitement.tournament.strategies;

import com.nespresso.sofa.recruitement.tournament.fighter.Fighter;

public interface EngagementStrategy
{
  void setFirstFighter(final Fighter fighter);
  
  void setSecondFighter(final Fighter fighter);
  
  void engage();
}
