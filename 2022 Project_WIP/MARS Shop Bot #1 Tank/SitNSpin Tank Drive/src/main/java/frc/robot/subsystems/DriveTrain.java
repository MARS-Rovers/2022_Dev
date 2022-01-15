// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {
  TalonSRX leftFront, leftRear, rightFront, rightRear;
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftFront = new TalonSRX(Constants.LeftFrontID);
    leftRear = new TalonSRX(Constants.LeftRearID);
    rightFront = new TalonSRX(Constants.RightFrontID);
    rightRear = new TalonSRX(Constants.RightRearID);
    rightFront.setInverted(true);
    rightRear.setInverted(true);
  }

  public void setPower(double leftPower, double rightPower) {
    leftFront.set(TalonSRXControlMode.PercentOutput, leftPower);
    leftRear.set(TalonSRXControlMode.PercentOutput, leftPower);
    rightFront.set(TalonSRXControlMode.PercentOutput, rightPower);
    rightRear.set(TalonSRXControlMode.PercentOutput, rightPower); 
   }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
