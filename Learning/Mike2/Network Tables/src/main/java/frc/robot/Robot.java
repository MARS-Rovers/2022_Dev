// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


/**
 * This is a sample program which uses joystick buttons to control a relay. A Relay (generally a
 * spike) has two outputs, each of which can be at either 0V or 12V and so can be used for actions
 * such as turning a motor off, full forwards, or full reverse, and is generally used on the
 * compressor. This program uses two buttons on a joystick and each button corresponds to one
 * output; pressing the button sets the output to 12V and releasing sets it to 0V.
 */

public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private final Joystick m_stick = new Joystick(0);
  private final Relay m_relay = new Relay(0);
  private final DigitalInput input = new DigitalInput(0);
  private final DigitalInput input2 = new DigitalInput(1);
  private final AnalogPotentiometer pot = new AnalogPotentiometer(0, 270, -135);

  private static final int 
  private static final int kRelayForwardButton = 1;
  private static final int kRelayReverseButton = 2;

  @Override
  public void robotInit() {

  }
  
  @Override
  public void teleopPeriodic() {
    /*
     * Retrieve the button values. GetRawButton will
     * return true if the button is pressed and false if not.
     */
    
    boolean forwardjoystickbutton = m_stick.getRawButton(kRelayForwardButton);
    boolean reversejoystickbutton = m_stick.getRawButton(kRelayReverseButton);
    boolean forward = input.get();
    boolean reverse = input2.get();
    double analogReading = pot.get();
    
    SmartDashboard.putString("DB/String 0", "My 21 Char TestString");
    SmartDashboard.putBoolean("DB/Button 1", input.get());
    SmartDashboard.putBoolean("DB/Button 2", input2.get());
    SmartDashboard.putNumber("DB/Slider 0", pot.get());
    /*
     * Depending on the button values, we want to use one of
     * kOn, kOff, kForward, or kReverse. kOn sets both outputs to 12V,
     * kOff sets both to 0V, kForward sets forward to 12V
     * and reverse to 0V, and kReverse sets reverse to 12V and forward to 0V.
     */

    if (analogReading>10 && analogReading<135) {
      m_relay.set(Relay.Value.kForward);
    } else if (analogReading>-135 && analogReading<-10) {
      m_relay.set(Relay.Value.kReverse);
    } else {
      m_relay.set(Relay.Value.kOff);
    }
    
    if (forward && reverse) {
      m_relay.set(Relay.Value.kOn);
    } else if (forward) {
      m_relay.set(Relay.Value.kForward);
    } else if (reverse) {
      m_relay.set(Relay.Value.kReverse);
    } else {
      m_relay.set(Relay.Value.kOff);
    }
    
    if (forwardjoystickbutton && reversejoystickbutton) {
      m_relay.set(Relay.Value.kOn);
    } else if (forwardjoystickbutton) {
      m_relay.set(Relay.Value.kForward);
    } else if (reversejoystickbutton) {
      m_relay.set(Relay.Value.kReverse);
    } else {
      m_relay.set(Relay.Value.kOff);
    }
  }
}
