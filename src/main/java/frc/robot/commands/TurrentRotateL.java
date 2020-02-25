/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turrent;

public class TurrentRotateL extends CommandBase {
  
  private final Turrent m_Turrent;
  
  /**
   * Creates a new TurrentRotateL.
   */
  public TurrentRotateL(Turrent subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Turrent = subsystem;
    addRequirements(m_Turrent);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Turrent.rotateLeft();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_Turrent.STOP();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
