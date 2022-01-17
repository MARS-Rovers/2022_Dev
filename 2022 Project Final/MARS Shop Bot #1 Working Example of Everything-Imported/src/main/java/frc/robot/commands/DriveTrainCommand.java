// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.*; // '*' will import all subsystems
import edu.wpi.first.wpilibj2.command.CommandBase;
//Import objects that are needed -> Lightbulb will import automatically

public class DriveTrainCommand extends CommandBase {
  //Create command here...

  Joystick leftJoystick;
  Joystick rightJoystick;
  DriveTrain drivetrain;
  //Create necessary right joystick, left joystick, and DriveTrain objects

  /** Creates a new DriveTrainCommand. */
  public DriveTrainCommand(Joystick leftJoystick, Joystick rightJoystick, DriveTrain drivetrain) {
    //Define DriveTrain command that uses left joystick, right joystick, and DriveTrain

    this.leftJoystick = leftJoystick;
    this.rightJoystick = rightJoystick;
    this.drivetrain = drivetrain;
    //Link parameters for the command with objects that were created to be used in the command

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
    //Declare which subsystem the command uses -> drivetrain variable refers to DriveTrain subsystem

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPower = -leftJoystick.getY();
    //leftPower variable is set to the Y position of the left joystick -> Negative because of how joysticks Y values work

    double rightPower = -rightJoystick.getY();
    //rightPower variable is set to the Y position of the right joystick -> Negative because of how joysticks Y values work

    drivetrain.setPower (leftPower, rightPower);
    //Function for setting the speed of left side TalonSRX motor controllers and right side TalonSRX motor controllers in the DriveTrain subsystems
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
