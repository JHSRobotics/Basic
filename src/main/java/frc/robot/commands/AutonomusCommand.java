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
import frc.robot.subsystems.WheelShooter;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;

//import frc.robot.subsystems.myLimeLight;

//import

public class AutonomusCommand extends CommandBase {
  
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry tx = table.getEntry("tx");
  //private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry ta = table.getEntry("ta");
  private double x;
  //private double y;
  private double area;

  private double start;
  private double initialDriveStop;
  private double driveStop;
  private double lineup;
  private double shoot;
  private double end;
  private AutoTurrent m_AutoTurrent;
  private AutoShoot m_AutoShoot;
  private DriveTrain m_DriveTrain;
  private Intake m_Intake;
  private PopUpPistion m_PopUpPistion;
  private Turrent m_Turrent;
  private WheelShooter m_WheelShooter;
  private boolean Finsihed;
  /*
  private double Delay1;
  private double Delay1a;
  private double Delay2;
  private double Delay2a;
  private double Delay3;
  private double Delay3a;
  private double Delay4;
  private double Delay4a;
  private double Delay5;
  private double Delay5a;
  private double Delay6;
  private double Delay6a;
  private double Delay7;
  private double Delay7a;
  private double Delay8;
  private double Delay8a;
  */
  //private boolean isConditionMet = false;
  private boolean hasShot;

  /**
   * Creates a new AutoCommand.
   */
  public AutonomusCommand(DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveTrain = driveTrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    start = System.currentTimeMillis();
    lineup = start+1000;
    shoot = lineup+5000;
    initialDriveStop = shoot+1500;
    driveStop = initialDriveStop+1500;
    //end = driveStop+1500;
    Constants.TELEOP_DRIVE = false;
    Finsihed = false;
    hasShot = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    x = tx.getDouble(0.0);
    //System.out.println(first_stop);
    //System.out.println(System.currentTimeMillis());
    if (System.currentTimeMillis()<lineup){
      //Lineup
      m_AutoTurrent.execute();
    }
    else if (System.currentTimeMillis()>lineup && System.currentTimeMillis()<shoot && hasShot == false){
      hasShot = true;
      m_AutoShoot.initialize();
      new Thread() {
        public void run(){
          try{
          m_PopUpPistion.pistonUp();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonDown();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_Intake.setIntake(Constants.AUTO_INTAKE_SPEED);
          m_PopUpPistion.pistonUp();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonDown();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonUp();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonDown();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonUp();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonDown();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonUp();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonDown();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonUp();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonDown();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonUp();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonDown();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonUp();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_PopUpPistion.pistonDown();
          Thread.sleep(Constants.DELAY_AMOUNT);
          m_Intake.setIntake(0);
          m_WheelShooter.shooterOff();
          }catch(InterruptedException fail){
            System.out.println("Could not shoot autonomus");
          }
        }
      }.start();
      //m_PopUpPistion.pistonUp();
      System.out.println("Shoot");
    }
    else if (System.currentTimeMillis()>shoot && System.currentTimeMillis()<initialDriveStop){
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
    else if (System.currentTimeMillis()>driveStop){
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

  /*private void piston(){
    m_PopUpPistion.pistonUp();
    //wait
    m_PopUpPistion.pistonDown();
    //wait
  }
*/
}
