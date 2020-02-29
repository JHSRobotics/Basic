/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.WheelShooter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class ConstantAutoShoot extends CommandBase {

  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  //private NetworkTableEntry tx = table.getEntry("tx");
  //private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry ta = table.getEntry("ta");
  //private double x;
  //private double y;
  private double area;
  private boolean Finished;
  private WheelShooter m_WheelShooter;
  
  /**
   * Creates a new AutoShoot.
   */
  public ConstantAutoShoot(WheelShooter subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_WheelShooter = subsystem;
    addRequirements(m_WheelShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    area = ta.getDouble(0.0);
    if (Constants.AREA_10_FEET<area && area>Constants.AREA_11_FEET){
      m_WheelShooter.shoot10Ft();
      System.out.println("Shoot10");
    }
    else if (Constants.AREA_11_FEET<area && area>Constants.AREA_12_FEET){
      m_WheelShooter.shoot11Ft();
      System.out.println("Shoot11");
    }
    else if (Constants.AREA_12_FEET<area && area>Constants.AREA_13_FEET){
      m_WheelShooter.shoot12Ft();
      System.out.println("Shoot12");
    }
    else if (Constants.AREA_13_FEET<area && area>Constants.AREA_14_FEET){
      m_WheelShooter.shoot13Ft();
      System.out.println("Shoot13");
    }
    else if (Constants.AREA_14_FEET<area){
      m_WheelShooter.shoot14Ft();
      System.out.println("Shoot14");
    }
    else {
      m_WheelShooter.shooterHalfSpeed();
      System.out.println("Out of Range");
    }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_WheelShooter.shooterOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
