/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants;

public class PopUpPistion extends SubsystemBase {
  
  private Solenoid popPiston;
  /**
   * Creates a new PopUpPistion.
   */
  public PopUpPistion() {
    popPiston = new Solenoid(Constants.SHOOTER_PISTON);
  }

  public void pistonUp() {
    popPiston.set(true);
    //System.out.println("Piston Up");
  }

  public void pistonDown() {
    popPiston.set(false);
    //System.out.println("Piston Down");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
