/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Turrent;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class AutoTurrent extends CommandBase {

  private Turrent m_Turrent;
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry tx = table.getEntry("tx");
  private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry ta = table.getEntry("ta");
  private double x;
  private double y;
  private double area;
  private boolean Finished;

  /**
   * Creates a new AutoTurrent.
   */
  public AutoTurrent(Turrent subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Turrent = subsystem;
    addRequirements(m_Turrent);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Finished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      //read values periodically
      x = tx.getDouble(0.0);
      y = ty.getDouble(0.0);
      area = ta.getDouble(0.0);
    
      //post to smart dashboard periodically
      SmartDashboard.putNumber("LimelightX", x);
      SmartDashboard.putNumber("LimelightY", y);
      SmartDashboard.putNumber("LimelightArea", 
      area);
  
      System.out.println("LimelightX" + " " + x);
      System.out.println("LimelightY" + " " + y);
      System.out.println("LimelightArea" + " " + area);

    if (x>Constants.TURRENT_THRESHOLD) {
      m_Turrent.rotateLeft();
    }
    else if (x<-Constants.TURRENT_THRESHOLD) {
      m_Turrent.rotateRight();
    }
    else {
      m_Turrent.STOP();
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
