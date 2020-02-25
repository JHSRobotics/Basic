/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import edu.wpi.first.wpilibj.XboxController;

public class Intake extends SubsystemBase {
  
  private Talon intakeMotor;
  //private XboxController xboxController;

  /**
   * Creates a new Intake.
   */
  public Intake() {
    intakeMotor = new Talon(Constants.INTAKE_TALON);
  }

  public void setIntake(double speed) {
    intakeMotor.set(speed);
  }
  public void intakeOff() {
    intakeMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
