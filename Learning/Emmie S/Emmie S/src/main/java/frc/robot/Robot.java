// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
//import edu.wpi.first.wpilibj.PowerDistributionPanel;
//import edu.wpi.first.wpilibj.PowerDistributionPanel;
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * This is a sample program which uses joystick buttons to control a relay. A Relay (generally a
 * spike) has two outputs, each of which can be at either 0V or 12V and so can be used for actions
 * such as turning a motor off, full forwards, or full reverse, and is generally used on the
 * compressor. This program uses two buttons on a joystick and each button corresponds to one
 * output; pressing the button sets the output to 12V and releasing sets it to 0V.
 */

public class Robot extends TimedRobot {
  //private final Joystick m_stick = new Joystick(0);
  private final Relay m_relay = new Relay(0);
  //private final DigitalInput input = new DigitalInput(0);
  //private final DigitalInput input2 = new DigitalInput(1);
  private final AnalogPotentiometer pot = new AnalogPotentiometer(0, 270, -135);
  NetworkTableEntry inputEntry;
  NetworkTableEntry input2Entry;
  NetworkTableEntry potEntry;

  //private static final int kRelayForwardButton = 1;
  //private static final int kRelayReverseButton = 2;

  @Override
  public void robotInit() {
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("datatable");
    inputEntry = table.getEntry("forward");
    input2Entry = table.getEntry("reverse");
    potEntry = table.getEntry("analogReading");
  }

  boolean forward = false;
  boolean reverse = false;
  double analogReading = 0;
  
  @Override
  public void teleopPeriodic() {
    /*
     * Retrieve the button values. GetRawButton will
     * return true if the button is pressed and false if not.
     */
    inputEntry.setBoolean(forward);
    input2Entry.setBoolean(reverse);
    potEntry.setDouble(analogReading);
    //boolean forward = input.get();
    //boolean reverse = input2.get();
    double analogReading = pot.get();
    
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

	  PowerDistributionPanel examplePDP = new PowerDistributionPanel(0); 
    examplePDP.getVoltage();
    examplePDP.getTemperature();
    examplePDP.getTotalCurrent();
    examplePDP.getTotalEnergy();
    examplePDP.getCurrent(0);
    
    Spark spark = new Spark(0); //
    spark.set(-0.75); //
    
    VictorSP victor = new VictorSP(0); //
    victor.set(0.6); //

    
  }
}  
