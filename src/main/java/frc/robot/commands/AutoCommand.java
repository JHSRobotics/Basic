/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.commands.AutoTurrent;
import frc.robot.Constants;
//import frc.robot.commands.AutoShoot;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.PopUpPistion;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Turrent;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
//import frc.robot.subsystems.myLimeLight;

//import

public class AutoCommand extends CommandBase {
  
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry tx = table.getEntry("tx");
  //private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry ta = table.getEntry("ta");
  private double x;
  //private double y;
  private double area;

  //private double start;
  private double initialDriveStop;
  private double driveStop;
  private double lineup;
  private double shoot;
  private double end;
  //private AutoTurrent m_AutoTurrent;
  //private AutoShoot m_AutoShoot;
  private DriveTrain m_DriveTrain;
  private Intake m_Intake;
  private PopUpPistion m_PopUpPistion;
  private Turrent m_Turrent;
  private boolean Finsihed;

  /**
   * Creates a new AutoCommand.
   */
  public AutoCommand(DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveTrain = driveTrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //start = System.currentTimeMillis();
    initialDriveStop = System.currentTimeMillis()+500;
    driveStop = System.currentTimeMillis()+750;
    lineup = System.currentTimeMillis()+2000;
    shoot = System.currentTimeMillis()+5000;
    end=System.currentTimeMillis()+10000;
    Constants.TELEOP_DRIVE = false;
    Finsihed = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    x = tx.getDouble(0.0);
    //System.out.println(first_stop);
    //System.out.println(System.currentTimeMillis());
    if (System.currentTimeMillis()<initialDriveStop){
      //Fast Drive
      m_DriveTrain.setLeftMotor(Constants.AUTO_SPEED);
      m_DriveTrain.setRightMotor(Constants.AUTO_SPEED);
      System.out.println("FAST");
    }
    else if (System.currentTimeMillis()>initialDriveStop && System.currentTimeMillis()<driveStop){
      //Slow drive
      m_DriveTrain.setLeftMotor(Constants.AUTO_SPEED_SLOW);
      m_DriveTrain.setRightMotor(Constants.AUTO_SPEED_SLOW);
      System.out.println("Slow");
    }
    else if (System.currentTimeMillis()>driveStop && System.currentTimeMillis()<lineup){
      //Lineup
      if (x>Constants.TURRENT_THRESHOLD) {
        m_Turrent.rotateLeft();
      }
      else if (x<-Constants.TURRENT_THRESHOLD) {
        m_Turrent.rotateRight();
      }
      else {
        m_Turrent.STOP();
      }
      System.out.println("Turrent line up");
    }
    else if (System.currentTimeMillis()>lineup && System.currentTimeMillis()<shoot){
      System.out.println("Shoot");
    }
    else if (System.currentTimeMillis()>end){
      Finsihed = true;
      Constants.TELEOP_DRIVE = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Finsihed;
  }
}
