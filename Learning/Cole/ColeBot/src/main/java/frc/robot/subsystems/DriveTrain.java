// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveTrain extends SubsystemBase {

  TalonSRX leftFront, leftRear, rightFront, rightRear;
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftFront = new TalonSRX(Constants.leftFrontID);
    leftRear = new TalonSRX(Constants.leftRearID);
    rightFront = new TalonSRX(Constants.rightFrontID);
    rightRear = new TalonSRX(Constants.rightRearID);

    leftFront.setInverted(true);
    leftRear.setInverted(true);

    
  }
  public void setPower(double leftPower, double rightPower){

    leftFront.set(TalonSRXControlMode.PercentOutput, leftPower);
    leftRear.set(TalonSRXControlMode.PercentOutput, leftPower);
    //leftPower variable sets the speed of the left side TalonSRX motor controllers

    rightFront.set(TalonSRXControlMode.PercentOutput, rightPower);
    rightRear.set(TalonSRXControlMode.PercentOutput, rightPower); 
    //rightPower variable sets the speed of the right side TalonSRX motor controllers

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
