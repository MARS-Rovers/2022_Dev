// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
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
  private Joystick m_Stick;
  private final Relay m_relay = new Relay(0);
  private final DigitalInput input = new DigitalInput(0);

  private static final int kRelayForwardButton = 1;
  private static final int kRelayReverseButton = 2;
  
  @Override
  public void robotInit() {
    SpeedController m_frontLeft = new Spark(0);
    SpeedController m_rearLeft = new Spark(2);
    SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
 
    SpeedController m_frontRight = new Spark(1);
    SpeedController m_rearRight = new Spark(3);
    SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
    m_myRobot = new DifferentialDrive(m_left, m_right);
    m_Stick = new Joystick(0);

  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.arcadeDrive(-m_Stick.getY(), m_Stick.getX());
    /*
    boolean forward = m_Stick.getRawButton(kRelayForwardButton);
    boolean reverse = m_Stick.getRawButton(kRelayReverseButton);

    if (forward && reverse) {
      m_relay.set(Relay.Value.kOn);
    } else if (forward) {
      m_relay.set(Relay.Value.kForward);
    } else if (reverse) {
      m_relay.set(Relay.Value.kReverse);
    } else {
      m_relay.set(Relay.Value.kOff);
    }*/
    boolean m_prox = input.get();  

    if (m_prox) {
      m_relay.set(Relay.Value.kForward);
    } else {
      m_relay.set(Relay.Value.kOff);
    }
  }

  
  
}
