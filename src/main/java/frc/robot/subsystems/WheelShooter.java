/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Talon;
//import frc.robot.Constants;

public class WheelShooter extends SubsystemBase {
  
  private Talon shootWheel;
  /**
   * Creates a new WheelShooter.
   */
  public WheelShooter() {
    shootWheel = new Talon(Constants.SHOOTER_TALON);
  }

  public void shooterOn() {
    shootWheel.set(Constants.SHOOTER_SPEED);
  }

  public void shooterOff() {
    shootWheel.set(0);
  }

  public double getShooterMotor() {
    return shootWheel.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
