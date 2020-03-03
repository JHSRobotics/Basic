/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Winch;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.XboxController;

public class ArmCommand extends CommandBase {
  
  private final XboxController m_XboxController;
  private final Winch m_Winch;
  private final Arm m_Arm;

  /**
   * Creates a new ArmUp.
   */
  public ArmCommand(Arm arm, Winch winch, XboxController xboxController) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Arm = arm;
    m_Winch = winch;
    m_XboxController = xboxController;
    addRequirements(m_Arm, m_Winch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rTriggerValue = m_XboxController.getRawAxis(Constants.RIGHT_TRIGGER);
    double lTriggerValue = m_XboxController.getRawAxis(Constants.LEFT_TRIGGER);
    if (rTriggerValue>0) {
      //m_Arm.armUp(rTriggerValue*Constants.ARM_SPEED);
      m_Winch.winchOut(/*rTriggerValue*Constants.WINCH_SPEED_CAP*/);
      //System.out.println("Right trigger value: " + rTriggerValue);
    }
    else if (lTriggerValue>0) {
      //m_Arm.armDown(lTriggerValue*Constants.ARM_SPEED);
      m_Winch.winchIn(/*lTriggerValue*Constants.WINCH_SPEED_CAP*/);
      //System.out.println("Left trigger value: " + lTriggerValue);
    }
    else {
      m_Arm.armStop();
      m_Winch.winchStop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
