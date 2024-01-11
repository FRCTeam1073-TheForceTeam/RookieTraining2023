// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class AbsoluteDriveCommand extends CommandBase {
  public double power = 0.0;
  public double inititialPos = 0.0;
  public double desiredPos =  2.0;
  public double currentPos;

  public int ticksPerRevolution = 2048;
  public double radiansToSpin;
  double distance;
  DrivetrainSubsystem drivetrain;

  /** Creates a new AbsoluteDriveCommand. */
  public AbsoluteDriveCommand(DrivetrainSubsystem drivetrain, double radiansToSpin) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    this.radiansToSpin = radiansToSpin;
    addRequirements(drivetrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   distance = 0;
   power = .5;
   inititialPos = drivetrain.getPosition();
   drivetrain.setPower(power);
   desiredPos =  inititialPos + radiansToSpin;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentPos = drivetrain.getPosition();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   drivetrain.setPower(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (currentPos >= desiredPos);
  }
}