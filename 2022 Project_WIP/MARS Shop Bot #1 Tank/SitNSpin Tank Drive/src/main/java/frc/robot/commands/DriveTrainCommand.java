// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.*; // '*' will import all subsystems
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveTrainCommand extends CommandBase {

  Joystick leftJoystick;
  Joystick rightJoystick;
  DriveTrain drivetrain;

  /** Creates a new DriveTrainCommand. */
  public DriveTrainCommand(Joystick leftJoystick, Joystick rightJoystick, DriveTrain drivetrain) {
    this.leftJoystick = leftJoystick;
    this.rightJoystick = rightJoystick;
    this.drivetrain = drivetrain;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPower = -leftJoystick.getY();
    double rightPower = -rightJoystick.getY();
    drivetrain.setPower (leftPower, rightPower);
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
