/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;


public class BallIn extends CommandBase {

  private final Intake m_Intake;
  private final XboxController m_xboxController;
  /**
   * Creates a new BallIn
   */
  public BallIn(Intake subsystem, XboxController xboxController) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Intake = subsystem;
    m_xboxController = xboxController;
    addRequirements(m_Intake);
  }

  
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    double rTriggerValue = m_xboxController.getRawAxis(Constants.RIGHT_TRIGGER);
    double lTriggerValue = m_xboxController.getRawAxis(Constants.LEFT_TRIGGER);
    //System.out.println("Trigger value: " + rTriggerValue);
    if (Constants.TELEOP_INTAKE == true){
    if (rTriggerValue>0) {
      m_Intake.setIntake(-rTriggerValue);
      //System.out.println("Right trigger value: " + rTriggerValue);
    }
    else if (lTriggerValue>0) {
      m_Intake.setIntake(lTriggerValue);
      //System.out.println("Left trigger value: " + lTriggerValue);
    }
    else {
      m_Intake.intakeOff();
    }
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
