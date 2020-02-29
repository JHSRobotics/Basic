/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Victor;

public class Arm extends SubsystemBase {
  
  private final Victor arm;
  
  /**
   * Creates a new Arm.
   */
  public Arm() {
    arm = new Victor(Constants.WINCH_HOOK_VICTOR);
  }

  public void armUp(){
    arm.set(-Constants.ARM_SPEED);
  }

  public void armDown(){
    arm.set(Constants.ARM_SPEED);
  }
  
  public void armStop(){
    arm.set(0);
  }

  public void armStall(){
    arm.set(Constants.ARM_STALL_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
