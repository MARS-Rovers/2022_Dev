// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.math.controller.PIDController;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NavXGyroscope extends SubsystemBase {
  AHRS navX;
  PIDController pid;
  /** Creates a new NavXGyroscope. */
  public NavXGyroscope() {
    navX = new AHRS(SPI.Port.kMXP);
  }

  public void setHeader() {
    double zeroHeader = navX.getFusedHeading() - navX.getFusedHeading();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
