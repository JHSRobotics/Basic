/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Winch extends SubsystemBase {
  
  private Talon winch;

  /**
   * Creates a new Winch.
   */
  public Winch() {
    winch = new Talon(Constants.WINCH_LIFT_TALON);
  }

  public void winchIn(/*double speed*/){
    winch.set(-Constants.WINCH_LIFT_SPEED);
  }

  public void winchOut(/*double speed*/){
    winch.set(Constants.WINCH_LIFT_SPEED);
  }

  public void winchStop(){
    winch.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
