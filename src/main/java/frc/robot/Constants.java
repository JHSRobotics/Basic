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
    public static final double AUTO_SPEED = 0.3;
    public static final double AUTO_SPEED_SLOW = 0.1;
    public static boolean TELEOP_DRIVE = true;
    //public static final double TARGET_SPEED = 0.2;

    public static final int TURRET_VICTOR = 4;
    public static final double TURRENT_SPEED = 0.075;
    public static final double TURRENT_THRESHOLD = 1.5;

    public static final int ARM_TALON = 5;
    public static final double ARM_SPEED = 0.9;
    public static final double ARM_STALL_SPEED = 0;



    public static final int SHOOTER_VICTOR = 6;
    public static final double SHOOTER_SPEED = 0.9;
    public static final double HALF_SPEED = 0.68;
    public static final double AREA_10_FEET = 2.78;
    public static final double SPEED_10_FEET = 0.675;
    public static final double AREA_11_FEET = 2.5;
    public static final double SPEED_11_FEET = 0.7;
    public static final double AREA_12_FEET = 2;
    public static final double SPEED_12_FEET = 0.8;
    public static final double AREA_13_FEET = 1.86;
    public static final double SPEED_13_FEET = 0.85;
    public static final double AREA_14_FEET = 1.63;
    public static final double SPEED_14_FEET = 0.925;

    public static final int INTAKE_TALON = 7;
    public static final double INTAKE_SPEED = -0.75;
    public static final double AUTO_INTAKE_SPEED = -0.3;
    public static boolean TELEOP_INTAKE = true;

    public static final int WINCH_LIFT_TALON = 9;
    public static final double WINCH_SPEED_CAP = 0.9;
    public static final double WINCH_LIFT_SPEED = 0.8;


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
    public static final int MENU_BUTTON = 7;

    public static final long SHORT_DELAY_AMOUNT = 300;
    public static final long LONG_DELAY_AMOUNT = 1500;
}
