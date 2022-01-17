// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//Import objects that are needed -> Lightbulb will import automatically

public class Pneumatics extends SubsystemBase {
  //Create subsystem here...

  Compressor compressor;
  DoubleSolenoid solenoidDouble;
  Solenoid solenoidSingle1, solenoidSingle2;
  //solenoidSingle3   USE WHEN READY

  /** Creates a new Pneumatics. */
  public Pneumatics() {
    compressor = new Compressor(Constants.pneumaticsID, PneumaticsModuleType.CTREPCM);
    solenoidDouble = new DoubleSolenoid(Constants.pneumaticsID, PneumaticsModuleType.CTREPCM, Constants.doubleSolenoidForwardChannel, Constants.doubleSolenoidReverseChannel);
    solenoidSingle1 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.singleSolenoid1Channel);
    solenoidSingle2 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.singleSolenoid2Channel);
    //solenoidSingle3 = new Solenoid(Constants.pneumaticsID, Constants.singleSolenoid3Channel);
    
    
    //compressor.setClosedLoopControl(true);
  }

  public void doubleSolenoidSet(Value possibleValue) {
    solenoidDouble.set(possibleValue);
  }

  public void solenoidSingle1Set(Boolean possibleBoolean1) {
    solenoidSingle1.set(possibleBoolean1);
  }

  public void solenoidSingle2Set(Boolean possibleBoolean2) {
    solenoidSingle2.set(possibleBoolean2);
  }

  /*
  public void solenoidSingle3Set(Boolean possibleBoolean3) {
    solenoidSingle3.set(possibleBoolean3);
  } */

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
