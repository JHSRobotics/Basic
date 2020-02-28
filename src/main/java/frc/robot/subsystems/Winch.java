/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Winch extends SubsystemBase {
  
  private Victor winch;

  /**
   * Creates a new Winch.
   */
  public Winch() {
    winch = new Victor(Constants.WINCH_LIFT_VICTOR);
  }

  public void winchIn(){
    winch.set(Constants.WINCH_SPEED);
  }

  public void winchOut(){
    winch.set(-Constants.WINCH_SPEED);
  }

  public void winchStop(){
    winch.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
