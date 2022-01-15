// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.*; // '*' will import all subsystems
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcadeDriveTrainCommand extends CommandBase {

  Joystick rightJoystick;
  ArcadeDriveTrain arcadeDriveTrain;

  /** Creates a new DriveTrainCommand. */
  public ArcadeDriveTrainCommand(Joystick rightJoystick, ArcadeDriveTrain arcadeDriveTrain) {
    this.rightJoystick = rightJoystick;
    this.arcadeDriveTrain = arcadeDriveTrain;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arcadeDriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speedPower = -rightJoystick.getY();
    double turnPower = rightJoystick.getX();
    arcadeDriveTrain.arcadeDrive(speedPower, turnPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

