// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  
  Spark leftFrontSpark = null;
  Spark leftBackSpark = null;
  Spark rightFrontSpark = null;
  Spark rightBackSpark = null;

  SpeedControllerGroup leftMotors = null;
  SpeedControllerGroup rightMotors = null;

  DifferentialDrive differentialDrive = null;

  public Drivetrain() {
    // Sparks
    leftFrontSpark = new Spark(Constants.DRIVETRAIN_LEFT_FRONT_SPARK);
    rightFrontSpark = new Spark(Constants.DRIVETRAIN_RIGHT_FRONT_SPARK);
    leftBackSpark = new Spark(Constants.DRIVETRAIN_LEFT_BACK_SPARK);
    rightBackSpark = new Spark(Constants.DRIVETRAIN_RIGHT_BACK_SPARK);

    leftMotors = new SpeedControllerGroup(leftFrontSpark, leftBackSpark);
    rightMotors = new SpeedControllerGroup(rightFrontSpark, rightBackSpark);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors); 
  }
  
  public void arcadeDrive(double moveSpeed, double rotateSpeed){
    differentialDrive(moveSpeed, RotateSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
 will be called once per scheduler run
  }
}
