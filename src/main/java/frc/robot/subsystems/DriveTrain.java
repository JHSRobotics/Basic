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
//import edu.wpi.first.wpilibj.Talon;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  private Victor rightDriveVictor1;
  private Victor rightDriveVictor2;
  private Victor leftDriveVictor1;
  private Victor leftDriveVictor2;


  public DriveTrain() {    
    rightDriveVictor1 = new Victor(Constants.RIGHT_DRIVE_VICTOR_1);
    rightDriveVictor2 = new Victor(Constants.RIGHT_DRIVE_VICTOR_2);
    leftDriveVictor1 = new Victor(Constants.LEFT_DRIVE_VICTOR_1);
    leftDriveVictor2 = new Victor(Constants.LEFT_DRIVE_VICTOR_2);
  }

  public void setLeftMotor(double speed){
    //***Might want to set inverted instead
    rightDriveVictor1.set(-speed);
    rightDriveVictor2.set(-speed);
  }

  public void setRightMotor(double speed){
    leftDriveVictor1.set(speed);
    leftDriveVictor2.set(speed);
    //System.out.println("SET RIGHT");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
