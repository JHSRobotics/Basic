/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//import edu.wpi.first.wpilibj.Solenoid;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class  Constants {
    public static final int LEFT_DRIVE_VICTOR_1 = 0;
    public static final int LEFT_DRIVE_VICTOR_2 = 1;
    public static final int RIGHT_DRIVE_VICTOR_1 = 2;
    public static final int RIGHT_DRIVE_VICTOR_2 = 3;
    public static final double ROBOT_SPEED = 0.9;
    public static final double TARGET_SPEED = 0.2;

    public static final int TURRET_VICTOR = 4;
    public static final double TURRENT_SPEED = 0.1;
    public static final double TURRENT_THRESHOLD = 2;

    public static final int WINCH_HOOK_VICTOR = 5;
    public static final double WINCH_SPEED = 0.3;

    public static final int SHOOTER_TALON = 6;
    public static final double SHOOTER_SPEED = 1;

    public static final int INTAKE_TALON = 7;
    public static final double INTAKE_SPEED = -0.75;

    public static final int WINCH_LIFT_VICTOR = 8;
    public static final double ARM_SPEED = 0.3;
    public static final double ARM_STALL_SPEED = 0;

    public static final int SHOOTER_PISTON = 0;

    public static final int DRIVER_CONTROLLER = 0;
    public static final int ARM_CONTROLLER = 1;
    public static final int SHOOTER_CONTROLLER = 1;
    public static final int LEFT_STICK_Y = 1;
    public static final int RIGHT_STICK_Y = 5;
    public static final int RIGHT_TRIGGER = 3;
    public static final int LEFT_TRIGGER = 2;
    public static final int X_BUTTON = 3;
    public static final int Y_BUTTON = 4;
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON = 2;
    public static final int RIGHT_BUMPER = 5;
    public static final int LEFT_BUMPER = 6;
}
