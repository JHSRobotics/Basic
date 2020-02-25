/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WheelShooter;
//import edu.wpi.first.wpilibj.XboxController;;

public class BallShoot extends CommandBase {
  
  private final WheelShooter m_WheelShooter;
  //private final XboxController m_xboxController;
  
  /**
   * Creates a new BallShoot.
   */
  public BallShoot(WheelShooter subsystem /*,XboxController xboxController*/) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_WheelShooter = subsystem;
    //m_xboxController = xboxController;
    addRequirements(m_WheelShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    double wheelSpeed = m_WheelShooter.getShooterMotor();
    if (wheelSpeed > 0.1) {
      m_WheelShooter.shooterOff();
      //System.out.println("Set shooter off");
    }
    else
    {
      m_WheelShooter.shooterOn();
      //System.out.println("Set shooter full");
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
