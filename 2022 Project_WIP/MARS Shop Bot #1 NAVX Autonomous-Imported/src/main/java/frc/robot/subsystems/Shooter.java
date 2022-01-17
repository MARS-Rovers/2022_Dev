// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//Import objects that are needed -> Lightbulb will import automatically
//revrobotics is a vendor library that needs to be added to the program -> Allows access to CANSparkMax class
//Under WPILib Command Palette, select "Manage Vendor Libraries", then "Install new libraries (online)", and enter this URL: https://www.revrobotics.com/content/sw/max/sdk/REVRobotics.json


public class Shooter extends SubsystemBase {
  //Create subsystem here...

  CANSparkMax intakeMotor;
  //Create necessary CANSparkMax motor controller

  /** Creates a new Shooter. */
  public Shooter() {
    intakeMotor = new CANSparkMax(Constants.SparkMaxID, MotorType.kBrushless);
    //Define CANSparkMax motor controller with its CAN ID from Constants and motor type

  }

  public void setIntake(double power) {
    //Define setIntake function that Shooter subsystem will use to activate intake IN and intake OUT using power variable

    intakeMotor.set(power);
    //power variable decides whether to activate intake IN or intake OUT

  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
