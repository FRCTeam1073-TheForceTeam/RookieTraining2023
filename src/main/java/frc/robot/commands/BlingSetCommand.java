// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Bling;
import frc.robot.subsystems.OI;

public class BlingSetCommand extends Command {
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
      //Setting a color here will change the bling once on startup
  }
 /*  Red: 15, 0, 0
  * Orange: 24, 10, 0
  * Yellow: 20, 20, 1
  * Green: 0, 15, 15
  * Blue: 0, 0, 5
  * Purple: 9, 2, 6*/
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    bling.setRGBAll(25, 20, 5);
    System.out.println("It runs!");
    //SET COLOR BASED ON BUTTON
    /*if(oi.getRawButton(1)){
       bling.setRGBAll(15, 0, 0);
     }
     else if(oi.getRawButton(2)){
       bling.setRGBAll(24, 10, 0);
     }
     else if(oi.getRawButton(3)){
       bling.setRGBAll(20, 20, 1);
     }
     else if(oi.getRawButton(4)){
       bling.setRGBAll(0, 15, 0);
     }
     else if(oi.getRawButton(5)){
       bling.setRGBAll(0, 0, 5);
     }
     else if(oi.getRawButton(6)){
       bling.setRGBAll(9, 2, 6);
     }*/
    
      //Setting a color here will change the bling continuously while the robot is on

    @Override
  public void end(boolean interrupted) {
    bling.setRGBAll(0, 0, 0);
      //This never happens so don't set a color here
      //But usually we'd turn the lights off here
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}