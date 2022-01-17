// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//Import objects that are needed -> Lightbulb will import automatically
//phoenix is a vendor library that needs to be added to the program -> Allows access to TalonSRX class
//Under WPILib Command Palette, select "Manage Vendor Libraries", then "Install new libraries (online)", and enter this URL: http://devsite.ctr-electronics.com/maven/release/com/ctre/phoenix/Phoenix-latest.json


public class DriveTrain extends SubsystemBase {
  //Create subsystem here...

  TalonSRX leftFront, leftRear, rightFront, rightRear;
  //Create necessary TalonSRX motor controllers

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftFront = new TalonSRX(Constants.LeftFrontID);
    leftRear = new TalonSRX(Constants.LeftRearID);
    rightFront = new TalonSRX(Constants.RightFrontID);
    rightRear = new TalonSRX(Constants.RightRearID);
    //Define TalonSRX motor controllers with their CAN IDs from Constants

    rightFront.setInverted(true);
    rightRear.setInverted(true);
    //Invert right side TalonSRX motor controllers to run in the same direction as left side TalonSRX motor controllers (opposite sides of the robot) -> Differential Drive takes care of this
  }

  public void setPower(double leftPower, double rightPower) {
    //Define setPower function that DriveTrain subsystem will use to move robot using leftPower and rightPower variables

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
