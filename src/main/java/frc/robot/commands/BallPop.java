/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PopUpPistion;
//import edu.wpi.first.wpilibj.XboxController;

public class BallPop extends CommandBase {
  private final PopUpPistion m_popUpPiston;
  private long startTime;
  private boolean Finished;
  //private final XboxController m_xboxController;


  /**
   * Creates a new BallPop.
   */
  public BallPop(PopUpPistion subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_popUpPiston = subsystem;
    //m_xboxController = xboxController;
    addRequirements(m_popUpPiston);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
    m_popUpPiston.pistonDown();
    Finished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (startTime+300<System.currentTimeMillis()){
      m_popUpPiston.pistonUp();
      Finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Finished;
  }
}
