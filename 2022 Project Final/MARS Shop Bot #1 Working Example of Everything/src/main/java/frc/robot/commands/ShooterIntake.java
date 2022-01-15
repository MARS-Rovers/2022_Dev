// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
//Import objects that are needed -> Lightbulb will import automatically

public class ShooterIntake extends CommandBase {
  //Create command here...

  JoystickButton intakeInButton, intakeOutButton;
  Shooter shooter;
  //Create necessary intake IN button, intake Out button, and DriveTrain objects

  /** Creates a new ShooterIntake. */
  public ShooterIntake(JoystickButton intakeInButton, JoystickButton intakeOutButton, Shooter shooter) {
    
    
    this.intakeInButton = intakeInButton;
    this.intakeOutButton = intakeOutButton;
    this.shooter = shooter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.setIntake(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (intakeInButton.get()==true && intakeOutButton.get()==true) {
      shooter.setIntake(0);
    } else if (intakeInButton.get()==true) {
      shooter.setIntake(1);
    } else if (intakeOutButton.get()==true) {
      shooter.setIntake(-1);
    } else {
      shooter.setIntake(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.setIntake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
