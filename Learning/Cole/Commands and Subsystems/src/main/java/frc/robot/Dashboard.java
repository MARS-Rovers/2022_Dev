// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard extends SubsystemBase {
  /** Creates a new Dashboard. */
  public Dashboard() {}

  public void send(String message){
    SmartDashboard.putString("Console_0", message);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
