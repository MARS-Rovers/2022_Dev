// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
//Import objects that are needed -> Lightbulb will import automatically

public class IntakePosition extends CommandBase {
  //Create command here...

  JoystickButton solenoidSingle1Switch, solenoidSingle2Switch, solenoidDoubleForwardButton, solenoidDoubleReverseButton;
  Pneumatics pneumatics;

  /** Creates a new IntakePosition. */
  public IntakePosition(JoystickButton solenoidSingle1Switch, JoystickButton solenoidSingle2Switch, JoystickButton solenoidDoubleForwardButton, JoystickButton solenoidDoubleReverseButton, Pneumatics pneumatics) {
    this.solenoidSingle1Switch = solenoidSingle1Switch;
    this.solenoidSingle2Switch = solenoidSingle2Switch;
    this.solenoidDoubleForwardButton = solenoidDoubleForwardButton;
    this.solenoidDoubleReverseButton = solenoidDoubleReverseButton;
    this.pneumatics = pneumatics;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pneumatics);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pneumatics.doubleSolenoidSet(Value.kOff);
    pneumatics.solenoidSingle1Set(false);
    pneumatics.solenoidSingle2Set(false);
    //pneumatics.solenoidSingle3Set(null);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (solenoidSingle1Switch.get()==true) {
      pneumatics.solenoidSingle1Set(true);
    } else {
      pneumatics.solenoidSingle1Set(false);
    }
    
    if (solenoidSingle2Switch.get()==true) {
      pneumatics.solenoidSingle2Set(true);
    } else {
      pneumatics.solenoidSingle2Set(false);
    }

    if (solenoidDoubleForwardButton.get()==true && solenoidDoubleReverseButton.get()==true ) {
      pneumatics.doubleSolenoidSet(Value.kOff);
    } else if (solenoidDoubleForwardButton.get()==true) {
      pneumatics.doubleSolenoidSet(Value.kForward);
    } else if (solenoidDoubleReverseButton.get()==true ) {
      pneumatics.doubleSolenoidSet(Value.kReverse);
    } else {
      pneumatics.doubleSolenoidSet(Value.kOff);
    }
  }
    

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    pneumatics.doubleSolenoidSet(Value.kOff);
    pneumatics.solenoidSingle1Set(false);
    pneumatics.solenoidSingle2Set(false);
    //pneumatics.solenoidSingle3Set(null);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
