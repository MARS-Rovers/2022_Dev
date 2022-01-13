// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends CommandBase {
  SpeedController m_FrontLeftMotor = new Spark(0);
  SpeedController m_BackLeftMotor = new Spark(2);
  SpeedControllerGroup m_LeftMotors = new SpeedControllerGroup(m_FrontLeftMotor, m_BackLeftMotor);

  SpeedController m_FrontRightMotor = new Spark(1);
  SpeedController m_BackRightMotor = new Spark(3);
  SpeedControllerGroup m_RightMotors = new SpeedControllerGroup(m_FrontRightMotor, m_BackRightMotor);

  DifferentialDrive m_robotDrive = new DifferentialDrive(m_LeftMotors, m_RightMotors);
  
  ExampleSubsystem m_subsystem;
  public Drive(ExampleSubsystem m_subsystem2) throws InterruptedException {
    // Use addRequirements() here to declare subsystem dependencies.

    wait();
  }

  public Drive() {
}

// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_robotDrive.arcadeDrive(0.5, 0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_robotDrive.arcadeDrive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
