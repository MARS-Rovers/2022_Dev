// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveBase extends SubsystemBase {

  private final SpeedController m_FrontLeftMotor = new Spark(12);
  private final SpeedController m_BackLeftMotor = new Spark(13);
  private final SpeedControllerGroup m_LeftMotors = new SpeedControllerGroup(m_FrontLeftMotor, m_BackLeftMotor);

  private final SpeedController m_FrontRightMotor = new Spark(10);
  private final SpeedController m_BackRightMotor = new Spark(11);
  private final SpeedControllerGroup m_RightMotors = new SpeedControllerGroup(m_FrontRightMotor, m_BackRightMotor);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_LeftMotors, m_RightMotors);

  /** Creates a new Drive. */
  public DriveBase() {}

  public void setDrive(double speed, double direction){
    m_robotDrive.arcadeDrive(speed, direction);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
