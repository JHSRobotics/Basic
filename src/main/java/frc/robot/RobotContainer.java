/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import javax.annotation.WillClose;

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
  private final XboxController m_armController = new XboxController(Constants.ARM_CONTROLLER);
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final DriveCommand m_driveCommand = new DriveCommand(m_driveTrain, m_driveController);
  private final Intake m_Intake = new Intake();
  private final BallIn m_BallIn = new BallIn(m_Intake, m_driveController);
  //private final BallOut m_BallOut = new BallOut(m_Intake, m_driveController);
  private final PopUpPistion m_PopUpPistion = new PopUpPistion();
  private final BallPop m_BallPop = new BallPop(m_PopUpPistion);
  private final WheelShooter m_WheelShooter = new WheelShooter();
  private final BallShoot m_BallShoot = new BallShoot(m_WheelShooter /*,m_driveController*/);
  private final AutoShoot m_AutoShoot = new AutoShoot(m_WheelShooter);
  private final Turrent m_Turrent = new Turrent();
  private final TurrentRotateL m_TurrentRotateL = new TurrentRotateL(m_Turrent);
  private final TurrentRotateR m_TurrentRotateR = new TurrentRotateR(m_Turrent);
  private final AutoTurrent m_AutoTurrent = new AutoTurrent(m_Turrent);
  private final myLimeLight m_MyLimeLight = new myLimeLight();
  //private final autoTarget m_AutoTarget = new autoTarget(m_MyLimeLight, m_driveTrain);
  private final Winch m_Winch = new Winch();
  private final winchIn m_WinchIn = new winchIn(m_Winch);
  private final winchOut m_WinchOut = new winchOut(m_Winch);
  private final Arm m_Arm = new Arm();
  private final armUp m_ArmUp = new armUp(m_Arm, m_Winch);
  private final Toggle_Lights m_Toggle_Lights = new Toggle_Lights(m_MyLimeLight);
  private final AutoCommand m_autoCommand = new AutoCommand(m_driveTrain);
  private final ConstantAutoTurrent m_ConstantAutoTurrent = new ConstantAutoTurrent(m_Turrent);
  private final ConstantAutoShoot m_ConstantAutoShoot = new ConstantAutoShoot(m_WheelShooter);
  private final Shoot90 m_Shoot90 = new Shoot90(m_WheelShooter);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    //System.out.println("I'm Working");
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
    final JoystickButton DriverXButton;
    final JoystickButton DriverAButton;
    final JoystickButton DriverYButton;
    final JoystickButton DriverLeftBumper;
    final JoystickButton DriverRightBumper;
    final JoystickButton DriverMenuButton;
    final JoystickButton ArmRightBumper;
    final JoystickButton ArmLeftBumper;
    final JoystickButton ArmYButton;
    final JoystickButton ArmAButton;

    DriverAButton = new JoystickButton(m_driveController, Constants.A_BUTTON);
    DriverXButton = new JoystickButton(m_driveController, Constants.X_BUTTON);
    DriverYButton = new JoystickButton(m_driveController, Constants.Y_BUTTON);
    DriverMenuButton = new JoystickButton(m_driveController, Constants.MENU_BUTTON);
    DriverLeftBumper = new JoystickButton(m_driveController, Constants.LEFT_BUMPER);
    DriverRightBumper = new JoystickButton(m_driveController, Constants.RIGHT_BUMPER);
    ArmRightBumper = new JoystickButton(m_armController, Constants.RIGHT_BUMPER);
    ArmLeftBumper = new JoystickButton(m_armController, Constants.LEFT_BUMPER);
    ArmYButton = new JoystickButton(m_armController, Constants.Y_BUTTON);
    ArmAButton = new JoystickButton(m_armController, Constants.A_BUTTON);

    DriverXButton.whenPressed(m_BallPop);
    //DriverAButton.whenPressed(m_BallShoot);
    //DriverAButton.whenPressed(m_AutoShoot);
    DriverAButton.toggleWhenPressed(m_ConstantAutoShoot);
    //DriverYButton.whenPressed(m_AutoTurrent);
    DriverYButton.toggleWhenPressed(m_ConstantAutoTurrent);
    DriverMenuButton.whenPressed(m_Toggle_Lights);
    DriverLeftBumper.whileHeld(m_TurrentRotateL);
    DriverRightBumper.whileHeld(m_TurrentRotateR);
    ArmRightBumper.whileHeld(m_WinchOut);
    ArmLeftBumper.whileHeld(m_WinchIn);
    ArmYButton.toggleWhenPressed(m_ArmUp);
    ArmAButton.whenPressed(m_Shoot90);
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
