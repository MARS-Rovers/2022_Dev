
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

public class SitNSpin extends CommandBase {
  JoystickButton spinButtonLH, spinButtonRH;
  DriveTrain drivetrain;

  /** Creates a new SitNSpin. */
  public SitNSpin(JoystickButton spinButtonLH, JoystickButton spinButtonRH, DriveTrain drivetrain) {
    this.spinButtonLH = spinButtonLH;
    this.spinButtonRH = spinButtonRH;
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
    // System.out.println(spinButtonLH.get());
    if (spinButtonLH.get()==true) {
      drivetrain.arcadeDrive (0, 1);
    } else if (spinButtonRH.get()==true) {
      drivetrain.arcadeDrive (0, -1);
    } else {
      drivetrain.arcadeDrive (0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
