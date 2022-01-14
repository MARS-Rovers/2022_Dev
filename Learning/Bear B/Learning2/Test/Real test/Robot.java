// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically it contains the code
 * necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;

  @Override
  public void robotInit() {
    SpeedController m_frontLeft = new Spark(0);
    SpeedController m_rearLeft = new Spark(2);
    SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft); 
    
    SpeedController m_frontRight = new Spark(1);
    SpeedController m_rearRight = new Spark(3);
    SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
   
    m_myRobot = new DifferentialDrive(m_left, m_right);
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
     
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
  }
}
