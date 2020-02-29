/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Winch;

public class armUp extends CommandBase {
  
  private Arm m_Arm;
  private Winch m_Winch;
  
  /**
   * Creates a new armUp.
   */
  public armUp(Arm subsystem1, Winch subsystem2) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Arm = subsystem1;
    m_Winch = subsystem2;
    addRequirements(m_Arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Arm.armUp();
    //m_Winch.winchOut();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_Arm.armStop();
    //m_Winch.winchStop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
