// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*; // '*' will import all commands
import frc.robot.subsystems.*; // '*' will import all subsystems
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//Import objects that are needed -> Lightbulb will import automatically


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  //Example definition of a subsystem

  private final DriveTrain drivetrain = new DriveTrain();
  //Define DriveTrain subsystem

  private final Pneumatics pneumatics = new Pneumatics();
  //Define Pneumatics subsytem

  private final Shooter shooter = new Shooter();
  //Define Shooter subsytem


  private final Joystick leftJoystick = new Joystick(Constants.leftJoystickPort);
  //Define left joystick object

  private final Joystick rightJoystick = new Joystick(Constants.rightJoystickPort);
  //Define right joystick object

  private final JoystickButton spinButtonLH = new JoystickButton(leftJoystick, Constants.spinButtonLHNumber);
  //Define left hand spin button object on left joystick

  private final JoystickButton spinButtonRH = new JoystickButton(leftJoystick, Constants.spinButtonRHNumber);
  //Define right hand spin button object on left joystick

  private final Joystick pneumaticsButtonBox = new Joystick(Constants.pneumaticsButtonBoxPort);
  //Define button box object for controlling pneumatics

  private final JoystickButton solenoidSingle1Switch = new JoystickButton(pneumaticsButtonBox, Constants.solenoidSingle1SwitchNumber);
  //Define switch object for single solenoid #1 on pneumatics button box

  private final JoystickButton solenoidSingle2Switch = new JoystickButton(pneumaticsButtonBox, Constants.solenoidSingle2SwitchNumber);
  //Define switch object for single solenoid #2 on pneumatics button box

  private final JoystickButton solenoidDoubleForwardButton = new JoystickButton(pneumaticsButtonBox, Constants.solenoidDoubleForwardButtonNumber);
  //Define button object for double solenoid forward side on pneumatics button box

  private final JoystickButton solenoidDoubleReverseButton = new JoystickButton(pneumaticsButtonBox, Constants.solenoidDoubleReverseButtonNumber);
  //Define button object for double solenoid reverse side on pneumatics button box

  private final Joystick intakeButtonBox = new Joystick(Constants.intakeButtonBoxPort);
  //Define button box object for controlling shooter intake

  private final JoystickButton intakeInButton = new JoystickButton(intakeButtonBox, Constants.intakeInButtonNumber);
  //Define button object for intake IN on shooter intake button box

  private final JoystickButton intakeOutButton = new JoystickButton(intakeButtonBox, Constants.intakeOutButtonNumber);
  //Define button object for intake OUT on shooter intake button box


  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  //Example definition of a command

  private final DriveTrainCommand driveTrainCommand = new DriveTrainCommand(leftJoystick, rightJoystick, drivetrain);
  //Define DriveTrain command that uses left joystick object, right joystick object, and DriveTrain subsystem

  private final SitNSpin sitNspin = new SitNSpin(spinButtonLH, spinButtonRH, drivetrain);
  //Define SitNSpin command that uses left hand spin button object, right hand spin button object, and DriveTrain subsystem

  private final IntakePosition intakePosition = new IntakePosition(solenoidSingle1Switch, solenoidSingle2Switch, solenoidDoubleForwardButton, solenoidDoubleReverseButton, pneumatics);
  //Define IntakePosition command that uses switch object for single solenoid #1, switch object for single solenoid #2, button object for double solenoid forward side, button object for double solenoid reverse side, and Pneumatics subsystem

  private final ShooterIntake shooterIntake = new ShooterIntake(intakeInButton, intakeOutButton, shooter);
  //Define ShooterIntake command that uses button object for intake IN, button object for intake OUT, and Shooter subsystem


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    drivetrain.setDefaultCommand(driveTrainCommand);
    //DriveTrain subsystem should always run DriveTrain command

    pneumatics.setDefaultCommand(intakePosition);
    //Pneumatics subsystem should always run intakePosition command

    shooter.setDefaultCommand(shooterIntake);
    //Shooter subsystem should always run shooterIntake command

    spinButtonLH.whileHeld(sitNspin);
    //While left hand spin button is held, SitNSpin command should run

    spinButtonRH.whileHeld(sitNspin);
    //While right hand spin button is held, SitNSpin command should run

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

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
