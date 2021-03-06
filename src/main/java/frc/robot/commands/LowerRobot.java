/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Winch;

public class LowerRobot extends CommandBase {
  
  private final Winch m_Winch;

  /**
   * Creates a new LowerRobot.
   */
  public LowerRobot(Winch subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Winch = subsystem;
    addRequirements(m_Winch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Winch.winchOut(Constants.WINCH_LIFT_SPEED);
    System.out.println("Winch Out");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Winch.winchStop();
    System.out.println("Winch Stop");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
