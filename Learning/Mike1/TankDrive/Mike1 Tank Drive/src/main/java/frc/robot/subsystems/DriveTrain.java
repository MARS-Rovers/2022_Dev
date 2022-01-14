// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {
  WPI_TalonSRX leftFront,leftRear,rightFront,rightRear;
  SpeedControllerGroup leftMotors, rightMotors;
  DifferentialDrive differentialDrive;
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftFront = new WPI_TalonSRX(Constants.LeftFrontID);
    leftRear = new WPI_TalonSRX(Constants.LeftRearID);
    rightFront = new WPI_TalonSRX(Constants.RightFrontID);
    rightRear = new WPI_TalonSRX(Constants.RightRearID);
    //rightFront.setInverted(true);
    //rightRear.setInverted(true);
    leftMotors = new SpeedControllerGroup(leftFront, leftRear);
    rightMotors = new SpeedControllerGroup(rightFront, rightRear);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void setPower(double leftPower, double rightPower) {
    leftFront.set(TalonSRXControlMode.PercentOutput, leftPower);
    leftRear.set(TalonSRXControlMode.PercentOutput, leftPower);
    rightFront.set(TalonSRXControlMode.PercentOutput, rightPower);
    rightRear.set(TalonSRXControlMode.PercentOutput, rightPower); 
   }

   public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
   }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
