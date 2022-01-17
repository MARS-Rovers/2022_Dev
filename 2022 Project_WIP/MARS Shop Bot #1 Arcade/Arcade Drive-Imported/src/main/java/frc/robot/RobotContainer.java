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


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrain drivetrain = new DriveTrain();
  private final ArcadeDriveTrain arcadeDriveTrain = new ArcadeDriveTrain();
  private final Joystick rightJoystick = new Joystick(Constants.rightJoystickPort);
  private final JoystickButton spinButtonLH = new JoystickButton(rightJoystick, Constants.spinButtonLHNumber);
  private final JoystickButton spinButtonRH = new JoystickButton(rightJoystick, Constants.spinButtonRHNumber);

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final ArcadeDriveTrainCommand arcadeDriveTrainCommand = new ArcadeDriveTrainCommand(rightJoystick, arcadeDriveTrain);
  private final SitNSpin sitNspin = new SitNSpin(spinButtonLH, spinButtonRH, drivetrain);
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    arcadeDriveTrain.setDefaultCommand(arcadeDriveTrainCommand);
    spinButtonLH.whileHeld(sitNspin);
    spinButtonRH.whileHeld(sitNspin);

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
