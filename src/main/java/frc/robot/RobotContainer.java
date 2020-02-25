/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import java.sql.DriverAction;

import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;
//import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
//import frc.robot.commands.ExampleCommand;
//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final XboxController m_driveController = new XboxController(Constants.DRIVER_CONTROLLER);
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Command m_autoCommand = new AutoCommand();
  private final DriveCommand m_driveCommand = new DriveCommand(m_driveTrain, m_driveController);
  private final Intake m_Intake = new Intake();
  private final BallIn m_BallIn = new BallIn(m_Intake, m_driveController);
  //private final BallOut m_BallOut = new BallOut(m_Intake, m_driveController);
  private final PopUpPistion m_PopUpPistion = new PopUpPistion();
  private final BallPop m_BallPop = new BallPop(m_PopUpPistion);
  private final WheelShooter m_WheelShooter = new WheelShooter();
  private final BallShoot m_BallShoot = new BallShoot(m_WheelShooter /*,m_driveController*/);
  private final Turrent m_Turrent = new Turrent();
  private final TurrentRotateL m_TurrentRotateL = new TurrentRotateL(m_Turrent);
  private final TurrentRotateR m_TurrentRotateR = new TurrentRotateR(m_Turrent);
  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    CommandScheduler.getInstance().setDefaultCommand(m_driveTrain, m_driveCommand);
    CommandScheduler.getInstance().setDefaultCommand(m_Intake, m_BallIn);
    //CommandScheduler.getInstance().setDefaultCommand(m_PopUpPistion, m_BallOut);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //final JoystickButton IntakeButton;

    //IntakeButton = new JoystickButton(m_xboxC)    
    final JoystickButton XButton;
    final JoystickButton AButton;
    final JoystickButton LeftBumper;
    final JoystickButton RightBumper;
    AButton = new JoystickButton(m_driveController, Constants.A_BUTTON);
    XButton = new JoystickButton(m_driveController, Constants.X_BUTTON);
    LeftBumper = new JoystickButton(m_driveController, Constants.LEFT_BUMPER);
    RightBumper = new JoystickButton(m_driveController, Constants.RIGHT_BUMPER);
    XButton.whenPressed(m_BallPop);
    AButton.whenPressed(m_BallShoot);
    LeftBumper.whileHeld(m_TurrentRotateL);
    RightBumper.whileHeld(m_TurrentRotateR);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
