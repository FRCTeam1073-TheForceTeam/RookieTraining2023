// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Bling;
import frc.robot.subsystems.OI;

public class BlingSetCommand extends CommandBase {
  Bling bling;
  OI oi;

  /** Creates a new BlingSetCommand. */
  public BlingSetCommand(Bling bling_, OI oi_) {
    // Use addRequirements() here to declare subsystem dependencies.
    bling = bling_;
    oi = oi_;
    addRequirements(bling);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // bling.setRGB(0, 15, 0, 0);
    // bling.setRGB(1, 15, 0, 10); //pink
    // bling.setRGB(2, 24, 10, 0);
    // bling.setRGB(3, 20, 20, 1);
    // bling.setRGB(4, 0, 15, 0);
    // bling.setRGB(5, 0, 0, 5);
    // bling.setRGB(6, 5, 2, 6);
    // bling.setRGB(7, 9, 2, 6);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //SET COLOR BASED ON BUTTON
    // if(oi.getRawButton(1)){
    //   bling.setRGBAll(15, 0, 0);
    // }
    // else if(oi.getRawButton(2)){
    //   bling.setRGBAll(24, 10, 0);
    // }
    // else if(oi.getRawButton(3)){
    //   bling.setRGBAll(20, 20, 1);
    // }
    // else if(oi.getRawButton(4)){
    //   bling.setRGBAll(0, 15, 0);
    // }
    // else if(oi.getRawButton(5)){
    //   bling.setRGBAll(0, 0, 5);
    // }
    // else if(oi.getRawButton(6)){
    //   bling.setRGBAll(9, 2, 6);
    // }


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // bling.setRGBAll(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}