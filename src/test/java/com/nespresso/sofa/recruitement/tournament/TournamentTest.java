package com.nespresso.sofa.recruitement.tournament;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.nespresso.sofa.recruitement.tournament.fighter.Swordsman;
import com.nespresso.sofa.recruitement.tournament.fighter.Viking;

public class TournamentTest
{
  @Test
  public void SwordsmanVsViking()
  {

    Swordsman swordsman = new Swordsman();

    Viking viking = new Viking();

    swordsman.engage(viking);
    assertThat(swordsman.hitPoints()).isEqualTo(0);
    assertThat(viking.hitPoints()).isEqualTo(35);

  }
}
