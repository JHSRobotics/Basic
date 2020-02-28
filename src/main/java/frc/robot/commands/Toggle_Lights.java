/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.myLimeLight;
import limelightvision.limelight.frc.ControlMode.LedMode;

public class Toggle_Lights extends CommandBase {
  private myLimeLight m_MyLimeLight;
  /**
   * Creates a new Toggle_Lights.
   */
  public Toggle_Lights(myLimeLight subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_MyLimeLight = subsystem;
    addRequirements(m_MyLimeLight);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(m_MyLimeLight.getLimeLight().getLEDMode() != LedMode.kforceOff ){
      m_MyLimeLight.getLimeLight().setLEDMode(LedMode.kforceOff);
    }
    else{
      m_MyLimeLight.getLimeLight().setLEDMode(LedMode.kforceOn);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
