/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase {

  private final DriveTrain m_driveTrain;
  private final XboxController m_xboxController;
  /**
   * Creates a new DriveCommmand.
   */
  public DriveCommand(DriveTrain subsystem, XboxController xboxController) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveTrain = subsystem;
    m_xboxController = xboxController;
    addRequirements(m_driveTrain);
  }

  public double GetDriverRawAxis(int axis){
    return m_xboxController.getRawAxis(axis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStickY = GetDriverRawAxis(Constants.LEFT_STICK_Y);
    double rightStickY = GetDriverRawAxis(Constants.RIGHT_STICK_Y);

    m_driveTrain.setLeftMotor(leftStickY*Constants.ROBOT_SPEED);
    m_driveTrain.setRightMotor(rightStickY*Constants.ROBOT_SPEED);
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
