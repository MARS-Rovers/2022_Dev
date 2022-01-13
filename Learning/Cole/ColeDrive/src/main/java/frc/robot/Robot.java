// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//Import Items vvv
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Spark;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
//Import Items ^^^
public class Robot extends TimedRobot {
//Define Variables vvv
  AnalogPotentiometer analog;
  CANSparkMax m_spark;
  DifferentialDrive m_drive;
  int loopNum;
  int consoleSize = 1;
  
//Define Variables ^^^
  @Override
  public void robotInit() {
//On Start vvv
    analog = new AnalogPotentiometer(0);
    m_spark = new CANSparkMax(6, MotorType.kBrushless);
    m_drive = new DifferentialDrive(new Spark(0), new Spark(0));
    SmartDashboard.putString("ConsoleIn", " ");
    dashboardWidget("string", "Console", 4);
    dashboardWidget("number", "Dial" , 6);
    dashboardWidget("boolean", "Light" , 12);
    dashboardWidget("boolean", "CheckBox" , 12);
    dashboardWidget("boolean", "Button", 12);
//On Start ^^^
  }
  @Override
  public void teleopPeriodic() {
//On Update vvv    
    //m_spark.set(analog.get());    
    SmartDashboard.putNumber("Dial_1", m_spark.get());
    updateDashboard();
//On Update ^^^
   }
   @Override
   public void autonomousInit() {
    m_drive.tankDrive(20, 20);
   }
   public void updateDashboard(){
     dashboardWidget("boolean", "Button", 12);

   }
   public void dashboardWidget(String type, String displayName, int amount){
    loopNum = 0;
    while(loopNum < amount){
      if(type == "number"){
        SmartDashboard.putNumber(displayName + "_" + loopNum, 0);
      }
      if(type == "boolean"){
        SmartDashboard.putBoolean(displayName + "_" + loopNum, false);
      }
      if(type == "string"){
        SmartDashboard.putString(displayName + "_" + loopNum, "");
      }
      loopNum ++;
    }
   }
}
