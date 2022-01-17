// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int LeftFrontID = 12;
    //Define left front TalonSRX CAN ID

    public static final int LeftRearID = 13;
    //Define left rear TalonSRX CAN ID

    public static final int RightFrontID = 10;
    //Define right front TalonSRX CAN ID

    public static final int RightRearID = 11;
    //Define right rear TalonSRX CAN ID

    public static final int spinButtonLHNumber = 4;
    //Define left hand spin button number on left joystick for SitNSpin command

    public static final int spinButtonRHNumber = 5;
    //Define right hand spin button number on left joystick for SitNSpin command
    
    public static final int leftJoystickPort = 0;
    //Define left joystick port on driver station

    public static final int rightJoystickPort = 1;
    //Define right joystick port on driver station

    public static final int pneumaticsID = 5;
    //Define Pneumatics Control Module (PCM) CAN ID

    public static final int singleSolenoid1Channel = 0;
    //Define PCM channel for single solenoid #1

    public static final int singleSolenoid2Channel = 1;
    //Define PCM channel for single solenoid #2

    //public static final int singleSolenoid3Channel = 2; 
    //Define PCM channel for single solenoid #3
    //ANYTHING SOLENOID 3 IS NOT USED CURRENTLY!

    public static final int doubleSolenoidForwardChannel = 3;
    //Define PCM channel for double solenoid forward side

    public static final int doubleSolenoidReverseChannel = 4;
    //Define PCM channel for double solenoid reverse side

    public static final int pneumaticsButtonBoxPort = 2;
    //Define button box port on driver station for controlling pneumatics

    public static final int solenoidSingle1SwitchNumber = 6;
    //Define switch number on peumatics button box for single solenoid #1

    public static final int solenoidSingle2SwitchNumber = 5;
    //Define switch number on peumatics button box for single solenoid #2

    public static final int solenoidDoubleForwardButtonNumber = 3;
    //Define button number on peumatics button box for double solenoid forward side

    public static final int solenoidDoubleReverseButtonNumber = 4;
    //Define button number on peumatics button box for double solenoid reverse side

    public static final int SparkMaxID = 6;
    //Define shooter SparkMax CAN ID

    public static final int intakeButtonBoxPort = 3;
    //Define button box port on driver station for controlling shooter intake

    public static final int intakeInButtonNumber = 1;
    //Define button number on shooter intake button box for intake IN

    public static final int intakeOutButtonNumber = 2;
    //Define button number on shooter intake button box for intake OUT

}
